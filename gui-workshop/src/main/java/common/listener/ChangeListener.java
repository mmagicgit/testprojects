package common.listener;

import java.util.EventListener;

public interface ChangeListener extends EventListener {

	void modelHasChanged();
	
}
