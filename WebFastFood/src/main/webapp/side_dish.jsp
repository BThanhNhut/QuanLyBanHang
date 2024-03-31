<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="block-addon" style="margin-top: 5px; margin-left: 10px">
        <div style="max-height: 200px; overflow-y: scroll;" id="addon-bogo" class="c-add-on">
            
            <div class="addon-item">
                <span id="lbl_food">+ 1 piece beef patties</span>
                <div style="float: right">
                    <button onclick="AddOnMinus(207)">-</button>
                    <input id="txt_AddOn207" class="addon-no" type="number" min="0" value="0" oninput="CalAddOn(207)">
                    <button onclick="AddOnPlus(207)">+</button>
                </div>
                <span style="margin-right: 10px; float: right">20.000đ</span>
                <div id="lblAddOnPrice_207" style="display: none">20000</div>
                <div class="addon-id" style="display: none">207</div>
            </div>
            
            <div class="addon-item">
                <span id="lbl_food">+1 piece chicken patties</span>
                <div style="float: right">
                    <button onclick="AddOnMinus(208)">-</button>
                    <input id="txt_AddOn208" class="addon-no" type="number" min="0" value="0" oninput="CalAddOn(208)">
                    <button onclick="AddOnPlus(208)">+</button>
                </div>
                <span style="margin-right: 10px; float: right">25.000đ</span>
                <div id="lblAddOnPrice_208" style="display: none">25000</div>
                <div class="addon-id" style="display: none">208</div>
            </div>
            
            <div class="addon-item">
                <span id="lbl_food">+ 1 piece grilled chicken patties</span>
                <div style="float: right">
                    <button onclick="AddOnMinus(209)">-</button>
                    <input id="txt_AddOn209" class="addon-no" type="number" min="0" value="0" oninput="CalAddOn(209)">
                    <button onclick="AddOnPlus(209)">+</button>
                </div>
                <span style="margin-right: 10px; float: right">15.000đ</span>
                <div id="lblAddOnPrice_209" style="display: none">15000</div>
                <div class="addon-id" style="display: none">209</div>
            </div>
        </div>
    </div>
</body>
</html>