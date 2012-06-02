package com.andriy.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DatePicker;

public class StatisticsInfo extends Composite {

	private static StatisticsInfoUiBinder uiBinder = GWT
			.create(StatisticsInfoUiBinder.class);
	
	@UiField Label startTimeLabel;
	@UiField Label endTimeLabel;
	@UiField DatePicker startTimePicker;
	@UiField DatePicker endTimePicker;
	@UiField Button reportButton;

	interface StatisticsInfoUiBinder extends UiBinder<Widget, StatisticsInfo> {
	}

	public StatisticsInfo() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	@UiHandler("startTimePicker")
	void onStartTimeChanged(ValueChangeEvent<Date> event) {
		startTimeLabel.setText(format(event.getValue()));
	}
	
	@UiHandler("endTimePicker")
	void onEndTimeChanged(ValueChangeEvent<Date> event) {
		endTimeLabel.setText(format(event.getValue()));
	}
	
	private static String format(Date date) {
		return DateTimeFormat.getFormat("yyyy-MM-dd").format(date);
	}
	@UiHandler("reportButton")
	void onReportButtonClick(ClickEvent event) {
		PopupPanel panel = new PopupPanel(true);
		panel.setGlassEnabled(true);
		
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(new Label("XXX文具有限公司 进货报表"));
		vPanel.add(new Label("从" + format(startTimePicker.getValue())));
		vPanel.add(new Label("到" + format(endTimePicker.getValue())));
		vPanel.add(new Label("的 进货成本 为：432.9元"));
		vPanel.add(new Label("细则如下："));
		
		FlexTable table = new FlexTable();
		table.setBorderWidth(1);
		
		table.setText(0, 0, "项目");
		table.setText(0, 1, "单价");
		table.setText(0, 2, "数量");
		table.setText(0, 3, "运费");
		table.setText(0, 4, "成本");

		table.setText(1, 0, "订书钉");
		table.setText(1, 1, "0.1元");
		table.setText(1, 2, "1000");
		table.setText(1, 3, "0元");
		table.setText(1, 4, "100元");

		table.setText(2, 0, "订书机");
		table.setText(2, 1, "20元");
		table.setText(2, 2, "6");
		table.setText(2, 3, "0元");
		table.setText(2, 4, "120元");

		table.setText(3, 0, "花露水");
		table.setText(3, 1, "18.3元");
		table.setText(3, 2, "3");
		table.setText(3, 3, "0元");
		table.setText(3, 4, "54.9元");

		table.setText(4, 0, "鼠标");
		table.setText(4, 1, "79元");
		table.setText(4, 2, "2");
		table.setText(4, 3, "0元");
		table.setText(4, 4, "158元");
		
		vPanel.add(table);

		panel.setWidget(vPanel);
		panel.center();
	}
}
