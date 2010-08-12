package hPE.frontend.kinds;

import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.edits.InterfaceSliceEditPart;
import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.base.edits.UnitSliceEditPart;
import hPE.frontend.base.figures.ComponentFigure;
import hPE.frontend.base.figures.ConfigurationFigure;
import hPE.frontend.base.figures.EntryFigure;
import hPE.frontend.base.figures.InterfaceFigure;
import hPE.frontend.base.figures.InterfaceSliceFigure;
import hPE.frontend.base.figures.UnitFigure;
import hPE.frontend.base.figures.UnitSliceFigure;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;
import hPE.frontend.kinds.base.model.HBaseKindInterface;

import java.lang.reflect.Method;

/**
 * Base class of a kind configuration.
 * Every kind must have only one KindConfiguration subclass.
 * 
 * @author Rafael Sales - rafaelcds@gmail.com
 */
public abstract class KindConfiguration {

	public abstract Class<? extends ComponentEditPart<?, ?>> getComponentEditPartClass();

	public abstract Class<? extends ConfigurationEditPart<?, ?>> getConfigurationEditPartClass();

	public abstract Class<? extends EntryEditPart<?, ?>> getEntryEditPartClass();

	public abstract Class<? extends InterfaceEditPart<?, ?>> getInterfaceEditPartClass();

	public abstract Class<? extends InterfaceSliceEditPart<?, ?>> getInterfaceSliceEditPartClass();

	public abstract Class<? extends UnitEditPart<?, ?>> getUnitEditPartClass();

	public abstract Class<? extends UnitSliceEditPart<?, ?>> getUnitSliceEditPartClass();

	public abstract Class<? extends ComponentFigure> getComponentFigureClass();

	public abstract Class<? extends ConfigurationFigure> getConfigurationFigureClass();

	public abstract Class<? extends EntryFigure> getEntryFigureClass();

	public abstract Class<? extends InterfaceFigure> getInterfaceFigureClass();

	public abstract Class<? extends InterfaceSliceFigure> getInterfaceSliceFigureClass();

	public abstract Class<? extends UnitFigure> getUnitFigureClass();

	public abstract Class<? extends UnitSliceFigure> getUnitSliceFigureClass();

	public abstract Class<? extends HBaseKindComponent> getHBaseKindComponentClass();

	public abstract Class<? extends HBaseKindInterface> getHBaseKindInterfaceClass();

	public abstract Class<? extends HInterfaceSlice> getHInterfaceSliceClass();

	public abstract Class<? extends HUnit> getHUnitClass();

	public abstract Class<? extends HUnitSlice> getHUnitSliceClass();

	public abstract Class<? extends HUnitStub> getHUnitStubClass();

	public abstract Class<? extends IHUnit> getIHUnitClass();
	
	public abstract String getName();
	
	/**
	 * Gets the implementation (subclass) of the <code>clazz</code> if exists.
	 * @param <T>
	 * @param clazz
	 * @return returns the subclass if exists, otherwise returns null (not expected)
	 */
	@SuppressWarnings("unchecked")
	public <T> Class<T> getClassAssignableFrom(Class<T> clazz) {
		Method[] methods = getClass().getMethods();
		for (Method method : methods) {
			if (method.getParameterTypes().length == 0 && clazz.isAssignableFrom(method.getReturnType())) {
				try {
					return (Class<T>) method.invoke(this, new Object[0]);
				} catch (Exception e) {
					//Will never be thrown
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
