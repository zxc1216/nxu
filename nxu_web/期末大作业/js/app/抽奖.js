window.onload = function () {

}
var number = prompt("请输入你猜测的四位数字", "")
var num;
function randomNum() {
    var span = document.getElementsByTagName("span");
    for (var i = 0; i < span.length; i++) {
        num = parseInt(Math.random() * 10);
        span[i].innerHTML = num;
    }
}
var set;
var flag = true;
function beginNum() {
    if (flag == true) {
        set = setInterval(randomNum, 100);
    }
    flag = false;
}
function endNum() {
    clearInterval(set);
    if (num == number) {
        alert("恭喜你猜中了！！！");
    }
    else {
        alert("很遗憾，下次继续努力！");
    }
    flag = true;
}