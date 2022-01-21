package com.bkacad.nnt.simplemvcdemo.model;

import com.bkacad.nnt.simplemvcdemo.utils.Util;

public class MainIteratorImpl implements MainIterator {

    @Override
    public MyMessage handleGetData() {
        // Tạm thời fix -> tạo request ....

        // Fake kết quả -> nếu 1 trả về thành công, 0 là thất bại
        int rs = Util.getRandomNumber(1,100) % 2;
        if(rs == 0) return new MyMessage(0, "Lấy thất bại");
        return new MyMessage(1,"Hello from Server");
    }
}
