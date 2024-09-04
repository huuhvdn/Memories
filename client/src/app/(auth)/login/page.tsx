import { Button, Input } from "@/components";
import AuthLayout from "../auth";

type LoginForm = {
  username: string;
  password: string;
}

export default function LoginPage() {

  const styles = {
    cover: {
      backgroundImage: "linear-gradient(0deg, rgba(247,231,234,1) 50%, rgba(253,200,210,1) 100%)"
    }
  }
  return (
    <AuthLayout>
      <div className="tw-relative tw-h-[500px] tw-flex tw-ml-80 ">
        <div className="tw-w-80 tw-absolute tw-top-1/2 tw-right-80 -tw-translate-y-1/2">
          <form className="tw-flex tw-flex-col tw-bg-white tw-shadow-md tw-rounded-md tw-drop-shadow-md tw-p-10 tw-space-y-4 tw-z-50">
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

            <Input id="username" label="Username" type="text" />
            <Input id="password" label="Password" type="password" />
            <Button type="submit" text="Sign In" theme="primary" />
            <p className="tw-text-xs tw-text-center">Forgot your password?</p>
          </form>
        </div>
        <div className="tw-w-96 tw-shadow-md tw-rounded-md" style={styles.cover}>
        </div>
      </div>
    </AuthLayout>
  );
}
