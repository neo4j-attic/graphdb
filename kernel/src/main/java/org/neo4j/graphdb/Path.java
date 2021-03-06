/**
 * Copyright (c) 2002-2011 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.graphdb;

import java.util.Iterator;

/**
 * Represents a path in the graph. A path starts with a node followed by
 * pairs of {@link Relationship} and {@link Node} objects. The shortest path
 * is of length 0. Such a path contains only one node and no relationships.
 * 
 * During a traversal {@link Path} instances are emitted where the current
 * position of the traverser is represented by each such path. The current
 * node in such a traversal is reached via {@link Path#endNode()}.
 */
public interface Path extends Iterable<PropertyContainer>
{
    /**
     * Returns the start node of this path. It's also the first node returned
     * from the {@link #nodes()} iterable.
     * @return the start node.
     */
    Node startNode();

    /**
     * Returns the end node of this path. It's also the last node returned
     * from {@link #nodes()} iterable. If the {@link #length()} of this path
     * is 0 the end node returned by this method is the same as the start node.
     * 
     * If a path is emitted from a traverser the end node is the current node
     * where the traverser is at the moment.
     * 
     * @return the end node.
     */
    Node endNode();

    /**
     * Returns the last {@link Relationship} in this path.
     * 
     * @return the last {@link Relationship} in this path, or <code>null</code>
     *         if this path contains no {@link Relationship}s.
     */
    Relationship lastRelationship();

    /**
     * Returns all the relationships in between the nodes which this path
     * consists of.
     * @return the relationships in this path.
     */
    Iterable<Relationship> relationships();

    /**
     * Returns all the nodes in this path. The first node is the same as
     * {@link #startNode()} and the last node is the same as {@link #endNode()}.
     * In between those nodes there can be an arbitrary number of nodes. The
     * shortest path possible is just one node, where also the the start node is
     * the same as the end node.
     * 
     * @return the nodes in this path.
     */
    Iterable<Node> nodes();

    /**
     * Returns the length of this path. That is the number of relationships
     * (which is the same as the number of nodes minus one). The shortest path
     * possible is of length 0.
     *
     * @return the length (i.e. the number of relationships) in the path.
     */
    int length();

    /**
     * Returns a natural string representation of this path.
     *
     * The string representation shows the nodes with relationships
     * (and their directions) in between them.
     *
     * @return A string representation of the path.
     */
    @Override
    String toString();

    /**
     * Iterates through both the {@link Node}s and {@link Relationship}s of this
     * path in order. Interleaving {@link Node}s with {@link Relationship}s,
     * starting and ending with a {@link Node} (the {@link #startNode()} and
     * {@link #endNode()} respectively).
     *
     * @see Iterable#iterator()
     */
    Iterator<PropertyContainer> iterator();
}
