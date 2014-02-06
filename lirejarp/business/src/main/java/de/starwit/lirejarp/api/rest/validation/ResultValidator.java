package de.starwit.lirejarp.api.rest.validation;

import java.util.Collection;

import de.starwit.smartpsv.entity.AbstractEntity;

public class ResultValidator {
	
	public static ResultStateWrapper savedResultExists(AbstractEntity result) {
		ResultStateWrapper state = new ResultStateWrapper();
		
		if (result == null || result.getId() == null) {
			state.setState(ResultState.ERROR);
			state.setMessage("Der Eintrag konnte nicht gespeichert werden.");
		} else {
			state.setState(ResultState.OK);
			state.setMessage("Der Eintrag mit ID " + result.getId() + " wurde erfolgreich gespeichert.");
		}
		return state;
	}
	
	public static ResultStateWrapper found(AbstractEntity result) {
		
		ResultStateWrapper state = new ResultStateWrapper();
		
		if (result == null || result.getId() == null) {
			state.setState(ResultState.NOT_FOUND);
			state.setMessage("Der Eintrag wurde nicht gefunden.");
		} else {
			state = setStateOk(state);
		}
		return state;
	}

	public static ResultStateWrapper isNotEmpty(Collection<? extends AbstractEntity> result) {
		ResultStateWrapper wrapper = new ResultStateWrapper();
		wrapper = checkNotEmpty(result, wrapper);
		return wrapper;
	}

	public static ResultStateWrapper isNotEmpty(AbstractEntity result, Collection<? extends AbstractEntity> children) {
		ResultStateWrapper wrapper = found(result);
		if (ResultState.OK.equals(wrapper.getState())) {
			wrapper = checkNotEmpty(children, wrapper);
		}
		
		return wrapper;
	}
	
	private static ResultStateWrapper checkNotEmpty(Collection<? extends AbstractEntity> result,
			ResultStateWrapper wrapper) {
		if (result == null || result.size() == 0) {
			wrapper.setState(ResultState.EMPTY);
			wrapper.setMessage("Es wurden keine Einträge gefunden.");
		} else {
			wrapper = setStateOk(wrapper);
		}
		return wrapper;
	}
	
	private static ResultStateWrapper setStateOk(ResultStateWrapper state) {
		state.setState(ResultState.OK);
		state.setMessage("Es sind keine Fehler aufgetreten.");
		return state;
	}
}
