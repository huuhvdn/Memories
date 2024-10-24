"use client";
import { Alert, Snackbar } from "@mui/material";
import { createContext, useContext, useState } from "react";

interface IToastContext {
  showToastNotificationSuccess?: (message: string) => void;
  showToastNotificationError?: (message: string) => void;
  showToastNotificationWarning?: (message: string) => void;
}

const ToastContext = createContext<IToastContext>({
  showToastNotificationSuccess: () => {},
  showToastNotificationError: () => {},
  showToastNotificationWarning: () => {},
});

export const ToastProvider: React.FC<{ children: React.ReactNode }> = ({
  children,
}) => {
  const [show, setShow] = useState<boolean>(false);
  const [severity, setSeverity] = useState<"success" | "error" | "warning">(
    "success"
  );
  const [message, setMessage] = useState<string>("");
  const showToastNotificationSuccess = (message: string) => {
    setShow(true);
    setSeverity("success");
    setMessage(message);
  };
  
  const showToastNotificationError = (message: string) => {
    setShow(true);
    setSeverity("error");
    setMessage(message);
  };

  const showToastNotificationWarning = (message: string) => {
    setShow(true);
    setSeverity("warning");
    setMessage(message);
  };

  const handleClose = () => {
    setShow(false);
  };
  return (
    <ToastContext.Provider
      value={{
        showToastNotificationSuccess,
        showToastNotificationError,
        showToastNotificationWarning,
      }}
    >
      <div>
        <Snackbar
          open={show}
          autoHideDuration={2000}
          anchorOrigin={{ vertical: "top", horizontal: "right" }}
          onClose={handleClose}
        >
          <Alert onClose={handleClose} severity={severity}>
            {message}
          </Alert>
        </Snackbar>
      </div>
      {children}
    </ToastContext.Provider>
  );
};

export const useToast = () => useContext(ToastContext);
