//
// Joaquim Madeira, AlgC, June 2020
// João Manuel Rodrigues, AlgC, June 2020
//
// GraphShortestPathsWithQueue - QUEUE algorithm for the Shortest Paths Tree
//

#include "GraphShortestPathsWithQueue.h"

#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersQueue.h"
#include "IntegersStack.h"

struct _GraphShortestPathsWithQueue {
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

GraphShortestPathsWithQueue* GraphShortestPathsWithQueueExecute(
    Graph* g, unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphShortestPathsWithQueue* result =
      (GraphShortestPathsWithQueue*)malloc(
          sizeof(struct _GraphShortestPathsWithQueue));
  assert(result != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  result->graph = g;
  result->startVertex = startVertex;
  result->distance = (int*)malloc(sizeof(int) * (numVertices));
  result->predecessor = (int*)malloc(sizeof(int) * (numVertices));
  for (int i = 0; i < numVertices; i++) {
    result->distance[i] = INT_MAX;
  }
  result->distance[result->startVertex] = 0;
  Queue* q = QueueCreate(numVertices);
  QueueEnqueue(q, result->startVertex);

  while (!QueueIsEmpty(q)) {
    unsigned int currentVertex = QueueDequeue(q);
    unsigned int* neighbour = GraphGetAdjacentsTo(result->graph, currentVertex);
    int* neighbourDist = GraphGetDistancesToAdjacents(result->graph, currentVertex);
    for (int i = 1; i < neighbour[0] + 1; i++) {
      int nthNeighbour = neighbour[i];
      if (result->distance[nthNeighbour] > result->distance[currentVertex] + neighbourDist[i]) {
        result->distance[nthNeighbour] = result->distance[currentVertex] + neighbourDist[i];
        result->predecessor[nthNeighbour] = currentVertex;
        QueueEnqueue(q, nthNeighbour);
      }
    }
    free(neighbour);
    free(neighbourDist);
  }

  return result;
}

void GraphShortestPathsWithQueueDestroy(GraphShortestPathsWithQueue** p) {
  assert(*p != NULL);

  GraphShortestPathsWithQueue* aux = *p;

  free(aux->distance);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphShortestPathsWithQueueHasPathTo(
    const GraphShortestPathsWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return (p->distance[v] != INT_MAX);
}

int GraphShortestPathsWithQueueDistanceTo(const GraphShortestPathsWithQueue* p,
                                          unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->distance[v];
}

Stack* GraphShortestPathsWithQueuePathTo(const GraphShortestPathsWithQueue* p,
                                         unsigned int v) {
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

void GraphShortestPathsWithQueueShowPath(const GraphShortestPathsWithQueue* p,
                                         unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphShortestPathsWithQueuePathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  printf(" --- Distance = %d", p->distance[v]);

  StackDestroy(&s);
}

void GraphShortestPathsWithQueueDisplay(const GraphShortestPathsWithQueue* p) {
  printf("Não foi definida especificaçao do metodo");
}
