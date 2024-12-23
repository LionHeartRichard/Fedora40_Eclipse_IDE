package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class Graph<T> {

	private Map<T, Set<T>> adjacentList = new HashMap<>();

	private Set<T> cache = new HashSet<>();

	public Graph() {
	}

	public Graph(Map<T, Set<T>> adjacent) {
		this.adjacentList.clear();
		this.adjacentList = adjacent;
	}

	public Map<T, Set<T>> getAdjacentList() {
		return adjacentList;
	}

	public void setAdjacentList(Map<T, Set<T>> adjacentList) {
		this.adjacentList = adjacentList;
	}

	public Set<T> getCache() {
		return cache;
	}

	public void setCache(Set<T> cache) {
		this.cache = cache;
	}

	public int size() {
		return adjacentList.size();
	}

	public boolean isEmpty() {
		return adjacentList.isEmpty();
	}

	public void addVertex(T vertex) {
		adjacentList.put(vertex, new HashSet<T>());
	}

	public void addEdgeWithoutCheckNullByKeyMap(T topVertex, T vertex) {
		adjacentList.get(topVertex).add(vertex);
	}

	@JsonAnySetter
	public void addEdge(T topVertex, T vertex) {
		if (!adjacentList.containsKey(topVertex))
			addVertex(topVertex);
		if (!adjacentList.containsKey(vertex))
			addVertex(vertex);
		adjacentList.get(topVertex).add(vertex);
	}

	public void addEdge(T topVertex, T vertex, boolean bidirectional) {
		if (!adjacentList.containsKey(topVertex))
			addVertex(topVertex);
		if (!adjacentList.containsKey(vertex))
			addVertex(vertex);
		adjacentList.get(topVertex).add(vertex);
		if (bidirectional)
			adjacentList.get(vertex).add(topVertex);
	}

	public List<T> breadthFirstSearch(T topVertex) {
		if (adjacentList.containsKey(topVertex)) {
			List<T> result = new ArrayList<>();
			Set<T> cache = adjacentList.get(topVertex);
			result.addAll(cache);
			LinkedList<T> swap = new LinkedList<>(cache);
			while (!swap.isEmpty()) {
				T currentVertex = swap.pop();
				for (T subVertex : adjacentList.get(currentVertex)) {
					if (!cache.contains(subVertex)) {
						cache.add(subVertex);
						swap.add(subVertex);
						result.add(subVertex);
					}
				}
			}
			return result;
		}
		return null;
	}

	public Set<T> depthFirstSearch(T topVertex) {
		if (adjacentList.containsKey(topVertex)) {
			cache.clear();
			for (T vertex : adjacentList.get(topVertex)) {
				cache.add(vertex);
				traversalDFS(vertex);
			}
			return cache;
		}
		return null;
	}

	private void traversalDFS(T vertex) {
		Set<T> tmp = adjacentList.get(vertex);
		for (T subVertex : tmp) {
			cache.add(subVertex);
			traversalDFS(subVertex);
		}
	}

	public List<T> getListAllVertices() {
		List<T> vertices = new ArrayList<>(adjacentList.keySet());
		return vertices;
	}

	public Set<T> getSetAllVertices() {
		Set<T> vertices = new HashSet<>(adjacentList.keySet());
		return vertices;
	}

	public void removeVertices() {
		adjacentList.clear();
	}

	public void removeVertex(T vertex) {
		adjacentList.remove(vertex);
	}

	public boolean containsKey(T vertex) {
		return adjacentList.containsKey(vertex);
	}

}
