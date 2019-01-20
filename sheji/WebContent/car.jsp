<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/carts.css">
</head>
<body>

<section class="cartMain">
    <div class="cartMain_hd">
        <ul class="order_lists cartTop">
            <li class="list_chk">

                <input type="checkbox" id="all" class="whole_check">
                <label for="all"></label>
                      全选
            </li>
            <li class="list_con">游戏信息</li>
            <li class="list_info">平台</li>
            <li class="list_price">单价</li>
            <li class="list_amount">数量</li>
            <li class="list_sum">金额</li>
            <li class="list_op">操作 </li>
        </ul>
    </div>

    <div class="cartBox">
        <div class="shop_info">
            <div class="all_check">

                <input type="checkbox" id="shop_a" class="shopChoice">

            </div>

        </div>
        <div class="order_content">
            <ul class="order_lists">
                <li class="list_chk">
                    <input type="checkbox" id="checkbox_2" class="son_check">
                    <label for="checkbox_2"></label>
                </li>
                <li class="list_con">
                    <div class="list_img"><a href="javascript:;"><img src="images/888.jpg" alt=""></a></div>
                    <div class="list_text"><a href="javascript:;">Dark Souls 3</a></div>
                </li>
                <li class="list_info">
                    <p>PC</p>
                    <p>PS4</p>
                </li>
                <li class="list_price">
                    <p class="price">￥198</p>
                </li>
                <li class="list_amount">
                    <div class="amount_box">
                        <a href="javascript:;" class="reduce reSty">-</a>
                        <input type="text" value="1" class="sum">
                        <a href="javascript:;" class="plus">+</a>
                    </div>
                </li>
                <li class="list_sum">
                    <p class="sum_price">￥198</p>
                </li>
                <li class="list_op">
                    <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                </li>
            </ul>
            <ul class="order_lists">
                <li class="list_chk">
                    <input type="checkbox" id="checkbox_3" class="son_check">
                    <label for="checkbox_3"></label>
                </li>
                <li class="list_con">
                    <div class="list_img"><a href="javascript:;"><img src="images/666.jpg" alt=""></a></div>
                    <div class="list_text"><a href="javascript:;">Assassin's Creed: Odyssey</a></div>
                </li>
                <li class="list_info">
                    <p>PC</p>
                    <p>PS4</p>
                </li>
                <li class="list_price">
                    <p class="price">￥250</p>
                </li>
                <li class="list_amount">
                    <div class="amount_box">
                        <a href="javascript:;" class="reduce reSty">-</a>
                        <input type="text" value="1" class="sum">
                        <a href="javascript:;" class="plus">+</a>
                    </div>
                </li>
                <li class="list_sum">
                    <p class="sum_price">￥250</p>
                </li>
                <li class="list_op">
                    <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                </li>
            </ul>
            <ul class="order_lists">
                <li class="list_chk">
                    <input type="checkbox" id="checkbox_6" class="son_check">
                    <label for="checkbox_6"></label>
                </li>
                <li class="list_con">
                    <div class="list_img"><a href="javascript:;"><img src="images/777.jpg" alt=""></a></div>
                    <div class="list_text"><a href="javascript:;">Rainbow Six：Siege</a></div>
                </li>
                <li class="list_info">
                    <p>PC</p>
                    <p>PS4</p>
                </li>
                <li class="list_price">
                    <p class="price">￥180</p>
                </li>
                <li class="list_amount">
                    <div class="amount_box">
                        <a href="javascript:;" class="reduce reSty">-</a>
                        <input type="text" value="1" class="sum">
                        <a href="javascript:;" class="plus">+</a>
                    </div>
                </li>
                <li class="list_sum">
                    <p class="sum_price">￥180</p>
                </li>
                <li class="list_op">
                    <p class="del"><a href="javascript:;" class="delBtn">移除商品</a></p>
                </li>
            </ul>
        </div>
    </div>

    <div class="bar-wrapper">
        <div class="bar-right">
            <div class="piece">已选商品<strong class="piece_num">0</strong>件</div>
            <div class="totalMoney">共计: <strong class="total_text">0.00</strong></div>
            <div class="calBtn"><a href="javascript:;">结算</a></div>
        </div>
    </div>
</section>
<section class="model_bg"></section>
<section class="my_model">
    <p class="title">删除游戏<span class="closeModel">X</span></p>
    <p>您确认要删除该游戏订单？嗯？</p>
    <div class="opBtn"><a href="javascript:;" class="dialog-sure">确定</a><a href="javascript:;" class="dialog-close">关闭</a></div>
</section>

<script src="js/jquery.min.js"></script>
<script src="js/carts.js"></script>
</body>

            

