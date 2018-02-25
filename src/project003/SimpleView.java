package project003;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class SimpleView {
	private static final String POPUPMENU_ID = "project003.popupmenu.mypopupmenu";
	public static final String VIEW_ID = "project003.partdescriptor.showhellopartdescriptor";
	private StyledText styledText;
	
	@Inject
	public SimpleView() {}
	
	@PostConstruct
	public void postConstruct(Composite parent, EMenuService menuService) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		styledText = new StyledText(container, SWT.BORDER);
		menuService.registerContextMenu(styledText, POPUPMENU_ID);
	}

	public void appendText(String str) {
		this.styledText .append(str);
	}
	public void setText(String str) {
		this.styledText.setText(str);
	}

}