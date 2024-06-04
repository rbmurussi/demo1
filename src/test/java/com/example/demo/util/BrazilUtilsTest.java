package com.example.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BrazilUtilsTest {

    @Test
    void isValidateCPF() {
        Assert.isTrue(BrazilUtils.isValidateCPF("19839091069"), "Validate CPF failed");
        Assert.isTrue(BrazilUtils.isValidateCPF("62289608068"), "Validate CPF failed");
    }
}