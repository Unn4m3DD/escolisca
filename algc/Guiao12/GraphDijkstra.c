//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphDijkstra - Dijkstra Alg for the Shortest Paths Tree
//

#include "GraphDijkstra.h"

#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersStack.h"
#include "PriorityQueue.h"

struct _GraphDijkstra {
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

// FOR THE PRIORITY QUEUE /////////////////////////////////////////////

// The items in the priority queue will be ID:PRIORITY pairs (type ITEM)

typedef struct {
  int id;   // item id (assigned automatically = index in ITEM array)
  int pri;  // item priority (assigned by the user)
} ITEM;

// The priority comparator for items.
int comparator(const void* p1, const void* p2) {
  return ((ITEM*)p1)->pri - ((ITEM*)p2)->pri;
}

// The printer for items.
void printer(void* p) {
  ITEM* pitem = (ITEM*)p;
  printf("%d:%d", pitem->id, pitem->pri);
}

///////////////////////////////////////////////////////////////////////

GraphDijkstra* GraphDijkstraExecute(Graph* g, unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphDijkstra* result = (GraphDijkstra*)malloc(sizeof(struct _GraphDijkstra));
  assert(result != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  //
  // COMPLETAR !!
  //
  // CRIAR e INICIALIZAR os campos de result
  result->graph = g;
  result->startVertex = startVertex;
  result->distance = (int*)malloc(sizeof(int) * (numVertices));
  result->predecessor = (int*)malloc(sizeof(int) * (numVertices));
  for (int i = 0; i < numVertices; i++) {
    result->distance[i] = INT_MAX;
  }
  result->distance[result->startVertex] = 0;
  // EXECUTAR O ALGORITMO
  PriorityQueue* q = PriorityQueueCreate(numVertices, comparator, printer);
  ITEM items[numVertices];
  for (int i = 0; i < numVertices; i++) {
    items[i].id = i;
    items[i].pri = result->distance[i];
    PriorityQueueInsert(q, &items[i]);
  }

  while (!PriorityQueueIsEmpty(q)) {
    ITEM minVertex = *(ITEM*)PriorityQueueGetMin(q);
    unsigned int* neighbour = GraphGetAdjacentsTo(result->graph, minVertex.id);
    int* neighbourDist = GraphGetDistancesToAdjacents(result->graph, minVertex.id);
    for (int i = 1; i < neighbour[0] + 1; i++) {
      int nthNeighbour = neighbour[i];
      if (result->distance[nthNeighbour] > result->distance[minVertex.id] + neighbourDist[i]) {
        result->distance[nthNeighbour] = result->distance[minVertex.id] + neighbourDist[i];
        items[nthNeighbour].pri = result->distance[nthNeighbour];
        result->predecessor[nthNeighbour] = minVertex.id;
        PriorityQueueDecreasePriority(q, &items[nthNeighbour]);
      }
    }
    free(neighbour);
    free(neighbourDist);
    PriorityQueueRemoveMin(q);
  }

  return result;
}

void GraphDijkstraDestroy(GraphDijkstra** p) {
  assert(*p != NULL);

  GraphDijkstra* aux = *p;

  free(aux->distance);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphDijkstraHasPathTo(const GraphDijkstra* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return (p->distance[v] != INT_MAX);
}

int GraphDijkstraDistanceTo(const GraphDijkstra* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->distance[v];
}

Stack* GraphDijkstraPathTo(const GraphDijkstra* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = StackCreate(GraphGetNumVertices(p->graph));

  if (p->distance[v] == INT_MAX) {
    return s;
  }

  // Store the path
  for (unsigned int current = v; current != p->startVertex;
       current = p->predecessor[current]) {
    StackPush(s, current);
  }

  StackPush(s, p->startVertex);

  return s;
}

// DISPLAYING on the console

void GraphDijkstraShowPath(const GraphDijkstra* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphDijkstraPathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  printf(" --- Distance = %d", p->distance[v]);

  StackDestroy(&s);
}

void GraphDijkstraDisplay(const GraphDijkstra* p) {
  int vertexCount = GraphGetNumVertices(p->graph);
  for (int i = 0; i < vertexCount; i++) {
    GraphDijkstraShowPath(p, i);
  }
}
