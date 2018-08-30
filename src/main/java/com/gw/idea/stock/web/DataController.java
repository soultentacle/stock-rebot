package com.gw.idea.stock.web;

import com.gw.idea.stock.collector.HistoryKLineDataCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2018/8/30.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private HistoryKLineDataCollector historyKLineDataCollector;

    @RequestMapping("/getData/{code}/{year}")
    @ResponseBody
    public Object getData(@PathVariable String code, @PathVariable String year) {
        return historyKLineDataCollector.downloadData(code, year);
    }
}
