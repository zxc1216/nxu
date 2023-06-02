function showScore(type) {
    var msg = "";
    switch (type) {
        case 'A':
            {
                msg = "成绩为90~100";
                break;
            }
        case 'B':
            {
                msg = "成绩为80~89";
                break;
            }
        case 'C':
            {
                msg = "成绩为70~79";
                break;
            }
        case 'D':
            {
                msg = "成绩为60~69";
                break;
            }
        case 'E':
            {
                msg = "成绩低于60";
                break;
            }
        default:
            {
                msg = "成绩类型错误，请输入“A,B,C,D,E”中的任意一个类型。"
            }
    }
    alert(msg);
}

