import React from "react";
import Topbar from "../topbar/Topbar";
import Modal from "../modal/Modal";

type LayoutProps = {
  children?: React.ReactNode;
};

export default function Layout({ children }: LayoutProps) {
  return (
    <>
      <div className="main-layout tw-h-screen tw-w-full tw-bg-slate-100 tw-flex tw-flex-col">
        <Topbar />
        {children && <div className="tw-flex-1">{children}</div>}
      </div>
    </>
  );
}
