import React, { useEffect } from "react";
import Button from "../button/Button";
import ReactDOM from "react-dom";
import useModal from "@/hooks/useModal";
import Aos from "aos";

export type ModalProps = {
  title: string;
  acceptText: string;
  show?: boolean;
  hide?: boolean;

  children?: React.ReactNode;

  // Optional
  iconName?: string;
  handleAccept?: () => unknown;
  handleDismiss?: () => unknown;
  onClose: () => unknown;
};

export default function Modal({
  title = "Title",
  acceptText = "OK",
  show,
  children,
  onClose,
}: ModalProps) {
  useEffect(() => {
    Aos.init();
  }, []);

  const handleClose = () => {
    if (onClose) {
      onClose();
    }
  };

  return show
    ? ReactDOM.createPortal(
        <>
          <div className="modal-overlay tw-fixed tw-top-0 tw-bg-slate-500/50 tw-z-[999] tw-h-screen tw-w-full"></div>
          <div
            className="modal-wrapper tw-h-full tw-w-full tw-flex tw-justify-center tw-items-center tw-fixed tw-top-0 tw-left-0 tw-z-[1000]"
            onClick={handleClose}
          >
            <div
              className="tw-w-1/2 tw-flex tw-flex-col tw-bg-white tw-text-stone-600 tw-rounded"
              data-aos="zoom-in"
              onClick={(e) => e.stopPropagation()}
            >
              {title && (
                <div className="tw-p-4 tw-text-lg  tw-font-medium">{title}</div>
              )}
              <div className="tw-max-h-[400px] tw-overflow-auto tw-p-4">
                {children}
              </div>
              <div className="tw-px-4 tw-py-2 tw-flex tw-justify-end tw-items-center tw-gap-4">
                <Button
                  text="Cancel"
                  theme="light"
                  type="button"
                  onClick={handleClose}
                />
                <Button text={acceptText} theme="primary" type="button" />
              </div>
            </div>
          </div>
        </>,
        document.getElementById("main-layout") as HTMLElement
      )
    : null;
}
