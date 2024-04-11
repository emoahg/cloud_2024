package pers.emo.order.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pers.emo.commons.dto.PayDTO;
import pers.emo.commons.resp.ResultData;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    // private final String PROVIDER_PAY_URL = "http://localhost:8001";
    private final String PROVIDER_SERVICE_NAME = "http://provider-payment";

    private final RestTemplate restTemplate;

    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData addPay(@RequestBody PayDTO pay) {
        return restTemplate.postForObject(PROVIDER_SERVICE_NAME + "/pay/add", pay, ResultData.class);
    }

    @DeleteMapping(value = "/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData deletePay(@PathVariable("id") Integer id) {
        restTemplate.delete(PROVIDER_SERVICE_NAME + "/pay/del/{id}", id);
        return ResultData.success(null);
    }

    @PutMapping(value = "/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData updatePay(@RequestBody PayDTO payDTO) {
        restTemplate.put(PROVIDER_SERVICE_NAME + "/pay/update", payDTO);
        return ResultData.success(null);
    }

    @GetMapping(value = "/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData getById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PROVIDER_SERVICE_NAME + "/pay/get/{id}", ResultData.class, id);
    }

    @GetMapping(value = "/all")
    @Operation(summary = "查询所有流水", description = "查询支付流水方法")
    public ResultData getAll() {
        return restTemplate.getForObject(PROVIDER_SERVICE_NAME + "/pay/all", ResultData.class);
    }

}
