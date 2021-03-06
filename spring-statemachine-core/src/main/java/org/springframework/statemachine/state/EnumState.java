/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.statemachine.state;

import java.util.Collection;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.region.Region;

/**
 * A {@link State} implementation where state and event is enum based.
 * 
 * @author Janne Valkealahti
 *
 * @param <S> the type of state
 * @param <E> the type of event
 */
public class EnumState<S extends Enum<S>, E extends Enum<E>> extends AbstractSimpleState<S, E> {

	/**
	 * Instantiates a new enum state.
	 *
	 * @param id the id
	 */
	public EnumState(S id) {
		super(id);
	}

	/**
	 * Instantiates a new enum state.
	 *
	 * @param id the id
	 * @param pseudoState the pseudo state
	 */
	public EnumState(S id, PseudoState pseudoState) {
		super(id, pseudoState);
	}

	/**
	 * Instantiates a new enum state.
	 *
	 * @param id the id
	 * @param deferred the deferred
	 */
	public EnumState(S id, Collection<E> deferred) {
		super(id, deferred);
	}

	/**
	 * Instantiates a new enum state.
	 *
	 * @param id the id
	 * @param deferred the deferred
	 * @param entryActions the entry actions
	 * @param exitActions the exit actions
	 */
	public EnumState(S id, Collection<E> deferred, Collection<Action<S, E>> entryActions, Collection<Action<S, E>> exitActions) {
		super(id, deferred, entryActions, exitActions);
	}

	/**
	 * Instantiates a new enum state.
	 *
	 * @param id the id
	 * @param deferred the deferred
	 * @param entryActions the entry actions
	 * @param exitActions the exit actions
	 * @param pseudoState the pseudo state
	 */
	public EnumState(S id, Collection<E> deferred, Collection<Action<S, E>> entryActions, Collection<Action<S, E>> exitActions,
			PseudoState pseudoState) {
		super(id, deferred, entryActions, exitActions, pseudoState);
	}

	/**
	 * Instantiates a new enum state.
	 *
	 * @param id the id
	 * @param deferred the deferred
	 * @param entryActions the entry actions
	 * @param exitActions the exit actions
	 * @param pseudoState the pseudo state
	 * @param regions the regions
	 */
	public EnumState(S id, Collection<E> deferred, Collection<Action<S, E>> entryActions, Collection<Action<S, E>> exitActions,
			PseudoState pseudoState, Collection<Region<S, E>> regions) {
		super(id, deferred, entryActions, exitActions, pseudoState, regions);
	}

	/**
	 * Instantiates a new enum state.
	 *
	 * @param id the id
	 * @param deferred the deferred
	 * @param entryActions the entry actions
	 * @param exitActions the exit actions
	 * @param pseudoState the pseudo state
	 * @param submachine the submachine
	 */
	public EnumState(S id, Collection<E> deferred, Collection<Action<S, E>> entryActions, Collection<Action<S, E>> exitActions,
			PseudoState pseudoState, StateMachine<S, E> submachine) {
		super(id, deferred, entryActions, exitActions, pseudoState, submachine);
	}

	@Override
	public void exit(E event, StateContext<S, E> context) {
		Collection<Action<S, E>> actions = getExitActions();
		if (actions != null) {
			for (Action<S, E> action : actions) {
				action.execute(context);
			}			
		}
	}
	
	@Override
	public void entry(E event, StateContext<S, E> context) {
		Collection<Action<S, E>> actions = getEntryActions();
		if (actions != null) {
			for (Action<S, E> action : actions) {
				action.execute(context);
			}			
		}
	}
	
	@Override
	public String toString() {
		return "EnumState [getIds()=" + getIds() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
