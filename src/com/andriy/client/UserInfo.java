package com.andriy.client;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class UserInfo extends Composite {

	private static UserInfoUiBinder uiBinder = GWT
			.create(UserInfoUiBinder.class);

	interface UserInfoUiBinder extends UiBinder<Widget, UserInfo> {
	}
	
	@UiField(provided=true)
	CellList<String> userList = new CellList<String>(new MyCell());
	
	class MyCell extends ClickableTextCell {

		@Override
		public void onBrowserEvent(Context context, Element parent,
				String value, NativeEvent event,
				ValueUpdater<String> valueUpdater) {
	        super.onBrowserEvent(context, parent, value, event, valueUpdater);

	        if (value == null) {
				return;
			}
	        if ("click".equals(event.getType())) {
	        	final PopupPanel panel = new PopupPanel();
	        	panel.setGlassEnabled(true);

	        	Image image = new Image("http://www.2qqtouxiang.cn/uploads/allimg/101011/1_101011132633_4.gif");

	        	FlexTable table = new FlexTable();
	        	table.setText(0, 0, "姓名：");
	        	TextBox nameBox = new TextBox();
	        	nameBox.setText(value);
	        	table.setWidget(0, 1, nameBox);

	        	table.setText(1, 0, "信用评级：");
	        	table.setText(1, 1, "☆☆☆☆");

	        	table.setText(2, 0, "手机：");
	        	TextBox phoneBox = new TextBox();
	        	phoneBox.setText("13812345678");
	        	table.setWidget(2, 1, phoneBox);
	        	
	        	table.setText(3, 0, "邮箱：");
	        	TextBox mailBox = new TextBox();
	        	mailBox.setText("yuanzhang@hotmail.com");
	        	table.setWidget(3, 1, mailBox);
	        	
	        	table.setText(4, 0, "企业类型：");
	        	ListBox typeBox = new ListBox();
	        	typeBox.addItem("国有企业");
	        	table.setWidget(4, 1, typeBox);
	        	
	        	table.setText(5, 0, "行业：");
	        	ListBox careerBox = new ListBox();
	        	careerBox.addItem("家电");
	        	table.setWidget(5, 1, careerBox);
	        	
	        	table.setText(6, 0, "员工数量：");
	        	TextBox amountBox = new TextBox();
	        	amountBox.setText("138");
	        	table.setWidget(6, 1, amountBox);
	        	
	        	table.setText(7, 0, "通讯地址：");
	        	TextBox addressBox = new TextBox();
	        	addressBox.setText("皮包公司，没有地址");
	        	table.setWidget(7, 1, addressBox);
	        	
	        	table.setText(8, 0, "总交易金额：");
	        	table.setText(8, 1, "0元");
	        	
	        	table.setText(9, 0, "上次交易时间：");
	        	table.setText(9, 1, "未交易过");
	        	
	        	VerticalPanel vPanel = new VerticalPanel();
	        	vPanel.add(new Label("头像："));
	        	vPanel.add(image);
	        	vPanel.add(table);
	        	
	        	{
		        	Button saveButton = new Button("保存");
		        	Button cancelButton = new Button("取消");
		        	cancelButton.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							panel.hide();
						}
					});
		        	
		        	HorizontalPanel hPanel = new HorizontalPanel();
		        	hPanel.add(saveButton);
		        	hPanel.add(cancelButton);
		        	vPanel.add(hPanel);
	        	}
	        	
	        	panel.setWidget(vPanel);
	        	panel.center();
	        }
		}		
	
	}

	private ListDataProvider<String> userProvider;
	
	public UserInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		
		{
			List<String> data = Arrays.asList("路人甲", "路人乙", "路人丙");
			userProvider = new ListDataProvider<String>(data);
			userProvider.addDataDisplay(userList);
		}
	}

}
