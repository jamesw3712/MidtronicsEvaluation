package com.example.midtronicsevaluation.API;

import com.example.midtronicsevaluation.Model.Country;

public interface ApiResult {
    void onAPISuccess(Country country);
    void onError();
}
