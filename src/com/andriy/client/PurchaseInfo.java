package com.andriy.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PurchaseInfo extends Composite {

	private static PurchaseInfoUiBinder uiBinder = GWT
			.create(PurchaseInfoUiBinder.class);

	interface PurchaseInfoUiBinder extends UiBinder<Widget, PurchaseInfo> {
	}
	
	@UiField ListBox purveyorList;
	@UiField ListBox centerList;
	@UiField ListBox typeList;
	
	@UiField TextBox nameBox;
	@UiField TextBox amountBox;
	
	@UiField Button saveButton;
	@UiField Button cancelButton;
	
	public PurchaseInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		
		{
			List<String> data = Arrays.asList("同济大学", "黄渡理工学院", "五道口机械技术学院");
			for (String s : data) {
				purveyorList.addItem(s);
			}
		}
		{
			List<String> data = Arrays.asList("四平路校区", "嘉定校区", "沪西校区", "沪北校区");
			for (String s : data) {
				centerList.addItem(s);
			}
		}
		{
			List<String> data = Arrays.asList("办公用品", "车费", "五金", "其他");
			for (String s : data) {
				typeList.addItem(s);
			}
		}
		
	}

	public PurchaseInfo(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("saveButton")
	void onSaveClicked(ClickEvent event) {
		PopupPanel panel = new PopupPanel(true);
		panel.setGlassEnabled(true);
		
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(new Label("增加成功！"));
		vPanel.add(new Label("供货商："
				+ purveyorList.getItemText(purveyorList.getSelectedIndex())));
		vPanel.add(new Label("配送中心："
				+ centerList.getItemText(centerList.getSelectedIndex())));
		vPanel.add(new Label("商品名称：" + nameBox.getText()));
		vPanel.add(new Label("商品类型："
				+ typeList.getItemText(typeList.getSelectedIndex())));
		vPanel.add(new Label("商品数量：" + amountBox.getText()));
		
		panel.setWidget(vPanel);
		panel.center();
	}
}
