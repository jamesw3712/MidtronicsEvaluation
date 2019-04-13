package com.example.midtronicsevaluation.API;

import com.example.midtronicsevaluation.Model.Country;

import java.util.List;

public interface ApiResult {
    void onAPISuccess(List<Country> countries);
    void onError();
}
