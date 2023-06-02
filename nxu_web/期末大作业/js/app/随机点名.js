var namelist = ["王思聪", "王健林", "马云", "马化腾", "张沫雷", "贺海鹍", "王广前",
	"张三", "李四", "王二麻子", "JustinBieber"];
var mytime = null;
function doit() {
	var bt = window.document.getElementById("bt");
	if (mytime == null) {
		bt.innerHTML = "停止点名";
		show();
	} else {
		bt.innerHTML = "开始点名";
		clearInterval(mytime);
		mytime = null;
	}
}
function show() {
	var box = window.document.getElementById("box");
	var num = Math.floor(Math.random() * 100000) % namelist.length;
	box.innerHTML = namelist[num];
	mytime = setTimeout("show()", 1);
}