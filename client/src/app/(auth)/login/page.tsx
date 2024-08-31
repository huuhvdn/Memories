import { Button, Input } from "@/components";
import AuthLayout from "../auth";

export default function LoginPage() {
  return (
    <AuthLayout>
      <form className="tw-flex tw-flex-col tw-bg-white tw-shadow-md tw-rounded-md tw-drop-shadow-md tw-w-80 tw-p-10 tw-space-y-4 tw-z-50">
        <div className="">
          <p className="tw-text-xs">Start Save Your Memories</p>
          <div className="heading tw-text-xl">Sign In To Memories</div>
          <p className="tw-text-xs">
            Don't have an account?
            <a href="/register" className="tw-ml-1 tw-text-[#D75656] ">
              Sign Up
            </a>
          </p>
        </div>

        <Input id="username" label="Username" type="text" />
        <Input id="password" label="Password" type="password" />
        <Button type="submit" text="Sign In" theme="primary" />
        <p className="tw-text-xs tw-text-center">Forgot your password?</p>
      </form>
    </AuthLayout>
  );
}
