"use client";
import { Button, Input } from "@/components";
import AuthLayout from "../auth";
import React, { ChangeEvent, useEffect, useState } from "react";
import { Controller, SubmitHandler, useForm } from "react-hook-form";

type LoginForm = {
  username: string;
  password: string;
};

export default function LoginPage() {
  const {
    register,
    control,
    reset,
    handleSubmit,
    formState: { isSubmitSuccessful, errors },
  } = useForm<LoginForm>({
    defaultValues: {
      username: "",
      password: "",
    },
  });

  const styles = {
    cover: {
      backgroundImage:
        "linear-gradient(0deg, rgba(247,231,234,1) 50%, rgba(253,200,210,1) 100%)",
    },
  };

  const handleLogin = async (data: LoginForm) => {
    console.log(data);
  };

  useEffect(() => {
    if (isSubmitSuccessful) {
      reset();
    }
  }, [isSubmitSuccessful, reset]);

  return (
    <AuthLayout>
      <div className="tw-relative tw-h-[500px] tw-flex tw-ml-80">
        <div className="tw-w-80 tw-absolute tw-top-1/2 tw-right-80 -tw-translate-y-1/2">
          <form
            onSubmit={handleSubmit(handleLogin)}
            className="tw-flex tw-flex-col tw-bg-white tw-shadow-md tw-rounded-md tw-drop-shadow-md tw-p-10 tw-space-y-4 tw-z-50"
          >
            <div className="">
              <p className="tw-text-xs">Start Save Your Memories</p>
              <div className="heading tw-text-xl">Sign In To Memories</div>
              <p className="tw-text-xs">
                Do not have an account?
                <a href="/register" className="tw-ml-1 tw-text-[#D75656] ">
                  Sign Up
                </a>
              </p>
            </div>
            <Controller
              control={control}
              name="username"
              rules={{ required: true }}
              render={({
                field: { onChange, value },
                fieldState: { error },
              }) => (
                <Input
                  id="username"
                  onChange={onChange}
                  label="Username"
                  type="text"
                  value={value}
                  errorMessage={error && "Username is required"}
                />
              )}
            />
            <Controller
              control={control}
              name="password"
              rules={{ required: true }}
              render={({
                field: { onChange, value },
                fieldState: { error },
              }) => (
                <Input
                  id="password"
                  onChange={onChange}
                  label="Password"
                  type="password"
                  value={value}
                  errorMessage={error && "Password is required"}
                />
              )}
            />
            <Button type="submit" text="Sign In" theme="primary" />
            <p className="tw-text-xs tw-text-center">Forgot your password?</p>
          </form>
        </div>
        <div
          className="tw-w-96 tw-shadow-md tw-rounded-md"
          style={styles.cover}
        ></div>
      </div>
    </AuthLayout>
  );
}
