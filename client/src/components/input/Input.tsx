import { ChangeEvent, FormEvent } from "react";

export type InputProps = {
  id: string;
  label: string;
  type: "text" | "password" | "file";
  name?: string;
  placeholderText?: string;
  required?: boolean;
  disable?: boolean;
  classNames?: string;
  value?: string;
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
  errorMessage?: string;
};
export default function Input({
  type = "text",
  placeholderText = "",
  disable = false,
  required = false,
  id,
  label,
  classNames,
  name,
  value,
  onChange,
  errorMessage,
}: InputProps) {
  return (
    <div className="tw-flex tw-space-y-2 tw-flex-col">
      {label && (
        <label
          htmlFor={id}
          className="tw-block tw-text-xs tw-font-medium tw-text-slate-600"
        >
          {label}
        </label>
      )}

      <input
        type={type}
        id={id}
        className="tw-bg-transparent tw-outline-none tw-border tw-border-gray-300 tw-text-xs tw-rounded-lg tw-block tw-w-full tw-p-2"
        placeholder={placeholderText}
        value={value}
        required={required}
        onChange={onChange}
      />
      {errorMessage && (
        <p className="tw-text-xs tw-text-red-500">{errorMessage}</p>
      )}
    </div>
  );
}
