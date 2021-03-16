/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c109118106_w03;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import java.util.Date;

/**
 *
 * @author RXiau6
 */
public class FXMLDocumentController implements Initializable {

    private String[] stations = {"南港", "台北", "板橋", "桃園", "新竹", "苗栗", "台中", "彰化", "雲林", "嘉義", "台南", "左營"};
    private double price_business[][] = {
        {0, 260, 310, 500, 700, 920, 1330, 1510, 1660, 1880, 2290, 2500},//南港_商務
        {260, 0, 260, 440, 640, 850, 1250, 1430, 1600, 1820, 2230, 2440},//台北_商務
        {260, 310, 0, 400, 590, 800, 1210, 1390, 1550, 1780, 2180, 2390},//板橋_'商務
        {500, 440, 400, 0, 400, 620, 1010, 1210, 1370, 1580, 1990, 2200},//桃園_'商務
        {700, 640, 590, 400, 0, 410, 820, 1010, 1160, 1390, 1790, 2000},//新竹_'商務
        {920, 850, 800, 620, 410, 0, 610, 790, 950, 1160, 1580, 1790},//苗栗_'商務
        {1330, 1250, 1210, 1010, 790, 400, 0, 400, 550, 770, 1180, 1390},//台中_'商務
        {1510, 1430, 1390, 1210, 1010, 790, 400, 0, 370, 580, 1000, 1210},//彰化_'商務
        {1660, 1600, 1550, 1370, 1160, 950, 550, 370, 0, 430, 830, 1040},//雲林_'商務
        {1880, 1820, 1780, 1580, 1390, 1160, 770, 580, 430, 0, 620, 820},//嘉義_'商務
        {2290, 2230, 2180, 1990, 1790, 1580, 1180, 1000, 830, 620, 0, 410},//台南_'商務
        {2500, 2440, 2390, 2200, 2000, 1790, 1390, 1210, 1040, 820, 410, 0}//左營_'商務
    };
    private double price_normal[][] = {
        {0, 40, 70, 200, 330, 480, 750, 870, 970, 1120, 1390, 1530},//南港_普通
        {40, 0, 40, 160, 290, 430, 700, 820, 930, 1080, 1350, 1490},//台北_普通
        {70, 40, 0, 130, 260, 400, 670, 790, 900, 1050, 1320, 1460},//板橋_普通
        {200, 160, 130, 0, 130, 280, 540, 670, 780, 920, 1190, 1130},//桃園_普通
        {330, 290, 260, 130, 0, 140, 410, 540, 640, 790, 1060, 1200},//新竹_普通
        {480, 430, 400, 280, 140, 0, 270, 390, 500, 640, 920, 1060},//苗栗_普通
        {750, 700, 670, 540, 410, 270, 0, 130, 230, 380, 650, 790},//台中_普通
        {870, 820, 790, 670, 540, 390, 130, 0, 110, 250, 530, 670},//'彰化_普通
        {970, 930, 900, 780, 640, 500, 230, 110, 0, 150, 420, 560},//雲林_普通
        {1120, 1080, 1050, 920, 790, 640, 380, 250, 150, 0, 280, 410},//嘉義_普通
        {1390, 1350, 1320, 1190, 1060, 920, 650, 530, 420, 280, 0, 140, 0},//台南_普通
        {1530, 1490, 1460, 1330, 1200, 1060, 790, 670, 560, 410, 140, 0}//左營_普通
    };
    private double price_free[][] = {
        {0, 35, 65, 190, 320, 465, 725, 840, 940, 1085, 1345, 1480},//南港_自由
        {35, 0, 35, 155, 280, 415, 675, 795, 900, 1045, 1305, 1445},//台北_自由
        {65, 35, 0, 125, 250, 385, 645, 765, 870, 1015, 1280, 1415},//板橋_自由
        {190, 155, 125, 0, 125, 270, 520, 645, 755, 890, 1150, 1290},//桃園_自由
        {320, 280, 250, 125, 0, 135, 395, 520, 620, 765, 1025, 1160},//新竹_自由
        {465, 415, 385, 270, 135, 0, 260, 375, 485, 620, 890, 1025},//苗栗_自由
        {725, 675, 645, 520, 395, 260, 0, 125, 220, 365, 630, 765},//台中_自由
        {840, 795, 765, 645, 520, 375, 125, 0, 105, 240, 510, 645},//彰化_自由
        {940, 900, 870, 755, 620, 485, 220, 105, 0, 145, 405, 540},//雲林_自由
        {1085, 1045, 1015, 890, 765, 620, 365, 240, 145, 0, 270, 395},//嘉義_自由
        {1345, 1305, 1280, 1150, 1025, 890, 630, 510, 405, 270, 0, 135},//台南_自由
        {1480, 1445, 1415, 1290, 1160, 1025, 765, 645, 540, 395, 135, 0}//左營_自由
    };
    @FXML
    private ComboBox<String> startStation;
    @FXML
    private ComboBox<String> endStation;

    @FXML
    private Button stationSwitch_btn;
    @FXML
    private Button buy_btn;
    @FXML
    private TextArea result;
    @FXML
    private ToggleGroup seat_lv;
    @FXML
    private RadioButton business;
    @FXML
    private RadioButton normal;
    @FXML
    private RadioButton free;
    private RadioButton adult;
    private RadioButton child;
    @FXML
    private ComboBox<String> adult_tickets;
    @FXML
    private ComboBox<String> child_tickets;
    @FXML
    private RadioButton one_way;
    @FXML
    private ToggleGroup ticketType;
    @FXML
    private RadioButton round_trip;

    public void setting() {
        for (int i = 0; i < stations.length; i++) {
            startStation.getItems().add(stations[i]);
            endStation.getItems().add(stations[i]);
            String value = String.format("%d", i);
            adult_tickets.getItems().add(value);
            child_tickets.getItems().add(value);
        }
        startStation.setValue("台北");
        endStation.setValue("左營");
        normal.setSelected(true);
        adult_tickets.setValue("1");
        child_tickets.setValue("0");
        one_way.setSelected(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setting();
    }

    @FXML
    private void stationSwitch(ActionEvent event) {

        switching();

    }

    @FXML
    private void buyTicket(ActionEvent event) {

        int from = startStation.getSelectionModel().getSelectedIndex();
        int to = endStation.getSelectionModel().getSelectedIndex();
        String fromSt = startStation.getValue();
        String toSt = endStation.getValue();

        double amount = 0;
        int seatLevel = getSeatLevel();
        int adult = Integer.parseInt(adult_tickets.getValue());
        int child = Integer.parseInt(child_tickets.getValue());
        int tickets = getTickets();
        String ticketType = "";
        String seat = getSeat(seatLevel);
        if (tickets == 1) { //1=來回票
            amount = accountAmount(from, to, seatLevel, tickets, adult, child);
            result.appendText("---去程---\n");
            printMsg(fromSt, toSt, seat, adult, child, amount);
            result.appendText("---回程---\n");
            printMsg(toSt, fromSt, seat, adult, child, amount);
        } else {
            amount = accountAmount(from, to, seatLevel, tickets, adult, child);
            result.appendText(("---單程---\n"));
            printMsg(fromSt, toSt, seat, adult, child, amount);
        }
    }

    private void switching() {
        String startSt = startStation.getValue();
        String endSt = endStation.getValue();

        endStation.setValue(startSt);
        startStation.setValue(endSt);
    }

    private String getSeat(int seatLevel) {
        String seat = "";
        if (seatLevel == 0) {
            seat = "普通車廂";
        } else if (seatLevel == 1) {
            seat = "商務車廂";
        } else {
            seat = "自由座";
        }
        return seat;
    }

    private int getSeatLevel() {
        int seatLevel = 0; // 0=普通 1=商務 2=自由

        if (normal.isSelected()) {
            seatLevel = 0;
        } else if (business.isSelected()) {
            seatLevel = 1;
        } else {
            seatLevel = 2;
        }
        return seatLevel;
    }

    private int getTickets() {
        int type = 0; //0=one-way 1=round-trip
        if (one_way.isSelected()) {
            type = 0;
        } else {
            type = 1;
        }
        return type;
    }

    private double accountAmount(int start, int end, int seatLevel, int ticketType, int adult, int child) {
        double amount = 0;
        if (seatLevel == 0) {
            amount += (price_normal[start][end] * adult);
            amount += (price_normal[start][end] * child * 0.5);
        } else if (seatLevel == 1) {
            amount += (price_business[start][end] * adult);
            amount += (price_business[start][end] * child * 0.5);
        } else {
            amount += (price_free[start][end] * adult);
            amount += (price_free[start][end] * child * 0.5);
        }
        return amount;
    }

    private void printMsg(String fromSt, String toSt, String seat, int adult, int child, double amount) {
        String msg = String.format("%s->%s\n%s 全票%2d張 半票%2d張\n總價:  %.0f\n", fromSt, toSt, seat, adult, child, amount);
        result.appendText(msg);

        Date c = new Date();
        String datemsg = String.format("購買日期:%tY 年%tm 月%td 日\n", c, c, c);
        result.appendText(datemsg);
    }

}
