"use client";
import { UserType } from "@/common/types/user";
import { getFirstCharacter } from "@/common/utils/base";
import React, { useState } from "react";

export default function Topbar() {
  const [user, setUser] = useState<UserType>({
    firstName: "Huu",
    lastName: "Ha",
    id: 1,
    email: "huuha@m@.com",
    imageUrl: "",
  });
  return (
    <div className="tw-h-14 tw-shadow-md tw-px-8 tw-flex tw-justify-between tw-items-center">
      <div className="tw-text-stone-600">Nerver forget your memories</div>
      <div className="tw-flex tw-justify-between tw-items-center tw-gap-3">
        <div className="tw-text-sm tw-font-semibold tw-text-stone-600 md:tw-block tw-hidden">
          {user.firstName} {user.lastName}
        </div>
        <div className="tw-w-12 tw-h-12 tw-flex tw-justify-center tw-items-center tw-text-white tw-text-lg tw-bg-slate-400 tw-rounded-full tw-overflow-hidden tw-bg-cover">
          {user.imageUrl
            ? user.imageUrl
            : getFirstCharacter(`${user.firstName} ${user.lastName}`)}
        </div>
      </div>
    </div>
  );
}
