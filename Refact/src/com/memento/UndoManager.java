//package com.memento;
//
//import java.beans.PropertyChangeSupport;
//import java.util.Stack;
//
//import com.adm.SaveState;
//
//public class UndoManager {
//
//	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
//
//	private Stack<SaveState[]> undoStack = new Stack<SaveState[]>();
//	private Stack<SaveState[]> redoStack = new Stack<SaveState[]>();
//
//	private class OldState {
//		private SaveState[] SS = getUndoName();
//		private String redoName = getUndoName();
//		private boolean undoAvailable = isUndoAvailable();
//		private boolean redoAvailable = isRedoAvailable();
//	}
//
//	public void execute(Command command) {
//		try {
//			OldState oldState = new OldState();
//			command.execute();
//			if (isUndoAvailable() && undoStack.peek().isCollapsible(command)) {
//				undoStack.peek().collapse(command);
//			} else {
//				undoStack.push(command);
//			}
//			redoStack.clear();
//			fireChanges(oldState);
//		} catch (IllegalStateException e) {
//			// report and log
//		}
//	}
//
//	public void undo() {
//		if (!undoStack.isEmpty()) {
//			try {
//				OldState oldState = new OldState();
//				SaveState[] SS = undoStack.pop();
//				SS.undo();
//				redoStack.push(SS);
//
//			} catch (IllegalStateException e) {
//				// report and log
//			}
//		}
//	}
//
//	public void redo() {
//		if (!redoStack.isEmpty()) {
//			try {
//				OldState oldState = new OldState();
//				SaveState[] SS = redoStack.pop();
//				SS.redo();
//				undoStack.push(SS);
//			} catch (IllegalStateException e) {
//				// report and log
//			}
//		}
//	}
//
//	public boolean isUndoAvailable() {
//		return !undoStack.isEmpty();
//	}
//	public boolean isRedoAvailable() {
//		return !redoStack.isEmpty();
//	}
//
//	public SaveState[] getUndoName() {
//		if (isUndoAvailable()) {
//			return undoStack.peek();
//		}
//		return null;
//	}
//	public SaveState[] getRedoName() {
//		if (isRedoAvailable()) {
//			return redoStack.peek();
//		}
//		return null;
//	}
//}
