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
package org.neo4j.helpers;

public class Triplet<T1, T2, T3> extends Pair<T1, Pair<T2, T3>>
{
    private final T1 first;
    private final T2 second;
    private final T3 third;

    private Triplet( T1 first, T2 second, T3 third )
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <T1, T2, T3> Triplet<T1, T2, T3> of( T1 first, T2 other, T3 third )
    {
        return new Triplet<T1, T2, T3>( first, other, third );
    }

    @Override
    public T1 first()
    {
        return this.first;
    }

    /**
     * @return the second object in the triplet.
     */
    public T2 second()
    {
        return this.second;
    }

    /**
     * @return the third object in the triplet.
     */
    public T3 third()
    {
        return this.third;
    }

    @Override
    public Pair<T2, T3> other()
    {
        return Pair.of( second, third );
    }

    @Override
    public String toString()
    {
        return "(" + first() + ", " + second() + ", " + third() + ")";
    }

    @Override
    public int hashCode()
    {
        return ( ( 31 * hashCode( first() ) ) | hashCode( second() ) ) * 31 | hashCode( third() );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj ) return true;
        if ( obj instanceof Triplet )
        {
            if ( obj.getClass() != this.getClass() ) return false;
            Triplet that = (Triplet) obj;
            return equals( this.first, that.first ) && equals( this.second, that.second )
                   && equals( this.third, that.third );
        }
        return false;
    }
}
