import React, { ChangeEvent, KeyboardEvent } from "react";

export type TextareaProps = {
  id: string;
  label: string;
  name?: string;
  placeholderText?: string;
  required?: boolean;
  disable?: boolean;
  classNames?: string;
  value?: string;
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
  errorMessage?: string;
};

export default function Textarea({
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
}: TextareaProps) {
  const handleKeyDown = (event: KeyboardEvent<HTMLTextAreaElement>) => {
    if (event.key === "Enter") {
      event.stopPropagation();
    }
  };
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
      <textarea
        id={id}
        name={name}
        rows={5}
        placeholder={placeholderText}
        value={value}
        required={required}
        className="tw-bg-transparent tw-outline-none tw-border tw-border-gray-300 tw-text-xs tw-rounded-lg tw-block tw-w-full tw-p-2"
        onKeyDown={handleKeyDown}
      ></textarea>
      {errorMessage && (
        <p className="tw-text-xs tw-text-red-500">{errorMessage}</p>
      )}
    </div>
  );
}
