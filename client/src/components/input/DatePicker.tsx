import React, { useEffect, useRef, useState } from "react";
import Button from "../button/Button";

const MONTHS = [
  { id: 1, name: "January" },
  { id: 2, name: "February" },
  { id: 3, name: "March" },
  { id: 4, name: "April" },
  { id: 5, name: "May" },
  { id: 6, name: "June" },
  { id: 7, name: "July" },
  { id: 8, name: "August" },
  { id: 9, name: "September" },
  { id: 10, name: "October" },
  { id: 11, name: "November" },
  { id: 12, name: "December" },
];

const DAYS_OF_WEEKS = [
  {
    id: 1,
    day: "Su",
  },
  {
    id: 2,
    day: "Mo",
  },
  {
    id: 3,
    day: "Tu",
  },
  {
    id: 4,
    day: "We",
  },
  {
    id: 5,
    day: "Th",
  },
  {
    id: 6,
    day: "Fr",
  },
  {
    id: 7,
    day: "Sa",
  },
];

export interface IDatePicker {
  date: IdpDate | null;
  time?: IdpTime | null;
}

export interface IdpDate {
  day: number;
  month: number;
  year: number;
}

export interface IdpTime {
  hour: number;
  minute: number;
  second: number;
}

export type DatePickerProps = {
  label?: string;
};

export default function DatePicker({ label }: DatePickerProps) {
  const [year] = useState<number>(new Date().getFullYear());
  const [month] = useState<number>(new Date().getMonth() + 1);
  const [currentDay] = useState<number>(new Date().getDate());

  const [isShow, setIsShow] = useState<boolean>(false);

  const [calendar, setCalendar] = useState<number[]>([]);

  const [value, setValue] = useState<string>("");

  const convertMonthToText = (month: number) => {
    return MONTHS.find((x) => x.id === month)?.name;
  };

  const displayCalender = () => {
    const firstDay = new Date(year, month);
    const lastDay = new Date(year, month, 0);
    const firstDayIndex = firstDay.getDate();
    const totalDaysInMonth = lastDay.getDate();

    let newCalendar: number[] = Array(42).fill(0);
    for (let day = 1; day <= totalDaysInMonth; day++) {
      newCalendar[firstDayIndex + day - 1] = day;
    }
    setCalendar(newCalendar);
  };

  const toggleDatePicker = () => {
    setIsShow(!isShow);
  };

  const selectDate = async (day: number) => {
    const date: IDatePicker = {
      date: {
        day: day,
        month: month,
        year: year,
      },
    };
    setValue(
      `${year}-${month.toString().padStart(2, "0")}-${day
        .toString()
        .padStart(2, "0")}`
    );
    toggleDatePicker();
  };

  const clearValue = () => {
    setValue("");
  };

  useEffect(() => {
    displayCalender();
  }, [month]);

  return (
    <div className="tw-relative tw-flex tw-space-y-2 tw-flex-col">
      {label && (
        <label className="tw-block tw-text-xs tw-font-medium tw-text-slate-600">
          {label}
        </label>
      )}
      <div className="date-picker-input">
        <div
          className="tw-bg-transparent tw-cursor-pointer tw-border tw-border-gray-300 tw-text-xs tw-rounded-lg tw-block tw-w-full tw-py-2 tw-px-3"
          onClick={toggleDatePicker}
        >
          {value ? (
            <span className="tw-text-stone-600">{value}</span>
          ) : (
            <span className="tw-text-slate-300">YYYY-MM-DD</span>
          )}
        </div>
        {isShow && (
          <div className="datepicker tw-relative tw-max-w-[256px]">
            <div className="tw-border tw-rounded tw-shadow-lg tw-z-[9999] tw-bg-white tw-w-full tw-absolute tw-top-0 tw-right-0">
              <div className="tw-text-sm tw-font-semibold tw-text-blue-400 tw-block tw-text-center tw-py-2">
                {convertMonthToText(month)} {year}
              </div>
              <div className="tw-p-2">
                <div className="week tw-grid tw-grid-cols-7 tw-mb-2">
                  {DAYS_OF_WEEKS.map((x, index) => (
                    <div
                      key={index}
                      className="tw-text-sm tw-font-semibold tw-text-stone-600 tw-flex tw-justify-center tw-items-center"
                    >
                      {x.day}
                    </div>
                  ))}
                </div>
                <div className="days tw-grid tw-grid-cols-7">
                  {calendar &&
                    calendar.map((day, index) => (
                      <div
                        key={index}
                        className={`tw-text-sm tw-font-semibold tw-text-stone-600 tw-flex tw-justify-center tw-items-center tw-h-6 tw-w-6 tw-rounded-full ${
                          day !== 0 &&
                          "hover:tw-bg-blue-500 hover:tw-cursor-pointer hover:tw-text-white"
                        } ${currentDay === day && "tw-bg-slate-300"}`}
                        onClick={() => selectDate(day)}
                      >
                        {day > 0 ? day : ""}
                      </div>
                    ))}
                </div>
              </div>
              <div className="tw-p-2 tw-flex tw-justify-end tw-gap-3">
                <Button
                  type="button"
                  theme="light"
                  text="Clear"
                  onClick={clearValue}
                />
                <Button
                  type="button"
                  theme="secondary"
                  text="Close"
                  onClick={toggleDatePicker}
                />
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
