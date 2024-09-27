import React from "react";
import Button from "../button/Button";

export type ModalProps = {
  title: string;
  acceptText: string;

  // Optional
  iconName?: string;
  handleAccept?: () => unknown;
  handleDismiss?: () => unknown;
};

export default function Modal({
  title = "Title",
  acceptText = "OK",
}: ModalProps) {
  const handleAccept = () => {
    if (handleAccept) {
      handleAccept();
    }
  };
  return (
    <div className="tw-fixed tw-top-0 tw-bg-slate-300/50 tw-z-10 tw-h-screen tw-w-full">
      <div className="tw-h-full tw-w-full tw-flex tw-justify-center tw-items-center">
        <div className="tw-w-1/2 tw-flex tw-flex-col tw-bg-white tw-rounded">
          {title && (
            <div className="tw-p-4 tw-text-lg tw-text-slate-600 tw-font-medium">
              Create New
            </div>
          )}
          <div className="tw-max-h-[400px] tw-overflow-auto tw-p-4"></div>
          <div className="tw-px-4 tw-py-2 tw-flex tw-justify-end tw-items-center">
            <Button onClick={handleAccept} text={acceptText} theme="primary" type="button" />
          </div>
        </div>
      </div>
    </div>
  );
}
