//
// Joaquim Madeira, AlgC, May 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// GraphBFS - QUEUE-based Breadth-First Search
//

#include "GraphBFSWithQueue.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"
#include "IntegersQueue.h"
#include "IntegersStack.h"

struct _GraphBFSWithQueue {
  unsigned int* marked;
  int* distance;
  int* predecessor;
  Graph* graph;
  unsigned int startVertex;
};

GraphBFSWithQueue* GraphBFSWithQueueExecute(Graph* g, unsigned int startVertex) {
  assert(g != NULL);
  assert(0 <= startVertex && startVertex < GraphGetNumVertices(g));

  GraphBFSWithQueue* traversal =
      (GraphBFSWithQueue*)malloc(sizeof(struct _GraphBFSWithQueue));
  assert(traversal != NULL);

  unsigned int numVertices = GraphGetNumVertices(g);

  traversal->marked = (unsigned int*)calloc(numVertices, sizeof(unsigned int));
  assert(traversal->marked != NULL);

  traversal->predecessor = (int*)malloc(numVertices * sizeof(int));

  traversal->distance = (int*)malloc(numVertices * sizeof(int));
  assert(traversal->predecessor != NULL);
  for (int i = 0; i < numVertices; i++) {
    traversal->predecessor[i] = -1;
  }
  for (int i = 0; i < numVertices; i++) {
    traversal->distance[i] = numVertices + 1;
  }
  traversal->predecessor[startVertex] = 0;

  traversal->graph = g;
  traversal->startVertex = startVertex;

  // EFETUAR A TRAVESSIA
  int contains[numVertices];
  for (int i = 0; i < numVertices; i++) {
    contains[i] = 0;
  }
  contains[startVertex] = 1;
  int numVertex = GraphGetNumVertices(traversal->graph);
  Queue* queue = QueueCreate(numVertex > 10 ? numVertex : 10);

  QueueEnqueue(queue, startVertex);
  while (!QueueIsEmpty(queue)) {
    unsigned int currentVertex = QueueDequeue(queue);
    contains[currentVertex] = 0;
    traversal->marked[currentVertex] = 1;
    unsigned int* adjVertex = GraphGetAdjacentsTo(traversal->graph, currentVertex);
    for (int i = 1; i <= adjVertex[0]; i++) {
      int vertex = adjVertex[i];
      if (!traversal->marked[vertex]) {
        traversal->distance[vertex] = traversal->distance[currentVertex] + 1;
        traversal->predecessor[vertex] = currentVertex;
        if (!contains[vertex]) {
          contains[vertex] = 1;
          QueueEnqueue(queue, vertex);
        }
      }
    }
  }
  QueueDestroy(&queue);
  return traversal;
}

void GraphBFSWithQueueDestroy(GraphBFSWithQueue** p) {
  assert(*p != NULL);

  GraphBFSWithQueue* aux = *p;

  free(aux->marked);
  free(aux->predecessor);

  free(*p);
  *p = NULL;
}

// Getting the result

unsigned int GraphBFSWithQueueHasPathTo(const GraphBFSWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  return p->marked[v];
}

Stack* GraphBFSWithQueuePathTo(const GraphBFSWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = StackCreate(GraphGetNumVertices(p->graph));

  if (p->marked[v] == 0) {
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

void GraphBFSWithQueueShowPath(const GraphBFSWithQueue* p, unsigned int v) {
  assert(0 <= v && v < GraphGetNumVertices(p->graph));

  Stack* s = GraphBFSWithQueuePathTo(p, v);

  while (StackIsEmpty(s) == 0) {
    printf("%d ", StackPop(s));
  }

  StackDestroy(&s);
}

void GraphBFSWithQueueDisplay(const GraphBFSWithQueue* p) {
  int vertexCount = GraphGetNumVertices(p->graph);
  for (int i = 0; i < vertexCount; i++) {
    GraphBFSWithQueueShowPath(p, i);
  }
}
