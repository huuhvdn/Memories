"use client";
import { Button, Input } from "@/components";
import AuthLayout from "../auth";
import { Controller, useForm } from "react-hook-form";
import { useEffect } from "react";

type RegisterForm = {
  username: string;
  password: string;
  displayName: string;
  email: string;
};

export default function RegisterPage() {
  const styles = {
    cover: {
      backgroundImage:
        "linear-gradient(0deg, rgba(247,231,234,1) 50%, rgba(253,200,210,1) 100%)",
    },
  };

  const {
    register,
    control,
    reset,
    handleSubmit,
    formState: { isSubmitSuccessful, errors },
  } = useForm<RegisterForm>({
    defaultValues: {
      username: "",
      password: "",
      displayName: "",
      email: "",
    },
  });

  const handleRegister = async (data: RegisterForm) => {
    console.log(data);
  };

  useEffect(() => {
    if (isSubmitSuccessful) {
      reset();
    }
  }, [isSubmitSuccessful, reset]);

  return (
    <AuthLayout>
      <div className="tw-relative tw-h-[500px] tw-flex tw-mr-80 ">
        <div
          className="tw-w-96 tw-shadow-md tw-rounded-md"
          style={styles.cover}
        ></div>
        <div className="tw-w-80 tw-absolute tw-top-1/2 tw-left-80 -tw-translate-y-1/2">
          <form
            onSubmit={handleSubmit(handleRegister)}
            className="tw-flex tw-flex-col tw-bg-white tw-shadow-md tw-rounded-md tw-drop-shadow-md tw-p-10 tw-space-y-3 tw-z-50"
          >
            <div className="">
              <div className="heading tw-text-xl">Sign Up For Free</div>
              <p className="tw-text-xs">
                Already have an account?
                <a href="/login" className="tw-ml-1 tw-text-[#D75656] ">
                  Sign In
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

            <Controller
              control={control}
              name="displayName"
              rules={{ required: true }}
              render={({
                field: { onChange, value },
                fieldState: { error },
              }) => (
                <Input
                  id="displayName"
                  onChange={onChange}
                  label="Display name"
                  type="text"
                  value={value}
                  errorMessage={error && "Display name is required"}
                />
              )}
            />
            <Controller
              control={control}
              name="email"
              rules={{ required: true }}
              render={({
                field: { onChange, value },
                fieldState: { error },
              }) => (
                <Input
                  id="email"
                  onChange={onChange}
                  label="Email"
                  type="text"
                  value={value}
                  errorMessage={error && "Email is required"}
                />
              )}
            />
            <Button type="submit" text="Sign Up" theme="primary" />
          </form>
        </div>
      </div>
    </AuthLayout>
  );
}
