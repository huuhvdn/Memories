import { Button, Input } from "@/components";
import AuthLayout from "../auth";

export default function LoginPage() {
  return (
    <AuthLayout>
      <form className="tw-flex tw-flex-col tw-bg-white tw-shadow-md tw-rounded-md tw-drop-shadow-md tw-w-80 tw-p-10 tw-space-y-4 tw-z-50">
        <div className="">
          <div className="heading tw-text-xl">Sign Up For Free</div>
          <p className="tw-text-xs">
            Already have an account?
            <a href="/login" className="tw-ml-1 tw-text-[#D75656] ">
              Sign In
            </a>
          </p>
        </div>

        <Input id="username" label="Username" type="text" />
        <Input id="password" label="Password" type="password" />
        <Input id="fullName" label="Full name" type="text" />
        <Input id="email" label="Email" type="text" />
        <Button type="submit" text="Sign Up" theme="primary" />
      </form>
    </AuthLayout>
  );
}
