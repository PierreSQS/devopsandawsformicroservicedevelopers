package com.bharath.springcloud.controllers;

import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.repos.CouponRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	private final CouponRepo repo;

	public CouponRestController(CouponRepo repo) {
		this.repo = repo;
	}

	@PostMapping(value = "/coupons")
	public Coupon create(@RequestBody Coupon coupon) {

		return repo.save(coupon);

	}

	@GetMapping(value = "/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);

	}
}
