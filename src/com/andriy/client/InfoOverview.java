package com.andriy.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;

public class InfoOverview extends Composite {

	private static InfoOverviewUiBinder uiBinder = GWT
			.create(InfoOverviewUiBinder.class);
	@UiField
	Button shopsButton;
	@UiField
	Button deliveryButton;
	@UiField
	Button serviceButton;
	@UiField(provided = true)
	CellList<String> cellList = new CellList<String>(new MyCell());
	
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
	        	PopupPanel panel = new PopupPanel(true);
	        	panel.setGlassEnabled(true);

	        	InlineLabel label = new InlineLabel(value + "…………");
	        	InlineLabel label1 = new InlineLabel("商家：XXX");
	        	InlineLabel label2 = new InlineLabel("地址：上海市嘉定区曹安公路4800号");
	        	Image image = new Image("http://www.hostelcn.com/upfiles/tmp/2007072417263879.jpg");
	        	Label label3 = new Label("联系人：路人甲");
	        	Label label4 = new Label("联系电话：13812345678");
	        	Label label5 = new Label("支付类型：货到付款");
	        	Label label6 = new Label("信用等级：☆☆☆☆☆");
	        	InlineLabel label7 = new InlineLabel("成交量：50万");
	        	Label label8 = new Label("商家简介：这个人很懒，什么都没有留下。");

	        	VerticalPanel vPanel = new VerticalPanel();
	        	vPanel.add(label);
	        	vPanel.add(new Label());
	        	vPanel.add(label1);
	        	vPanel.add(label2);
	        	vPanel.add(image);
	        	vPanel.add(label3);
	        	vPanel.add(label4);
	        	vPanel.add(label5);
	        	vPanel.add(label6);
	        	vPanel.add(label7);
	        	vPanel.add(label8);
	        	
	        	panel.setWidget(vPanel);
	        	panel.center();
	        }
		}		
	}
	
	
	interface InfoOverviewUiBinder extends UiBinder<Widget, InfoOverview> {
	}
	
	private ListDataProvider<String> shopsDataProvider;

	public InfoOverview() {
		initWidget(uiBinder.createAndBindUi(this));
		shopsButton.addStyleName("hasmargin");
		deliveryButton.addStyleName("hasmargin");
		serviceButton.addStyleName("hasmargin");
		
		{
			List<String> data = new ArrayList<String>(8);
			data.add("李宁专卖店        "+ "ID:" + RandomGenerator.getRandomString(8));
			data.add("耐克专卖店        "+ "ID:" + RandomGenerator.getRandomString(8));
			data.add("阿迪王专卖店        "+ "ID:" + RandomGenerator.getRandomString(8));
			data.add("七匹狼专卖店        " + "ID:" + RandomGenerator.getRandomString(8));
//			data.add("沙县小吃        " + "ID:" + RandomGenerator.getRandomString(8));
			shopsDataProvider = new ListDataProvider<String>(data);	
		}		
		shopsDataProvider.addDataDisplay(cellList);
	}

}
