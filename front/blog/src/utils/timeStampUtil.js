function formatDate(timeStamp) {
    var now = new Date(timeStamp);   //创建一个指定的日期对象
    var year = now.getFullYear();  //取得4位数的年份
    var month = now.getMonth() + 1;  //取得日期中的月份，其中0表示1月，11表示12月
    var date = now.getDate();      //返回日期月份中的天数（1到31）
    //var hour = now.getHours();     //返回日期中的小时数（0到23）
    //var minute = now.getMinutes(); //返回日期中的分钟数（0到59）
    //var second = now.getSeconds(); //返回日期中的秒数（0到59）
    return year + "-" + month + "-" + date;//+ " " + hour + ":" + minute + ":" + second;
}

export default formatDate;