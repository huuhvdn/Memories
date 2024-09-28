"use client";
import {
  Button,
  DatePicker,
  Input,
  Layout,
  Modal,
  Textarea,
} from "@/components";
import useModal from "@/hooks/useModal";
import Aos from "aos";
import "aos/dist/aos.css";
import { useEffect, useState } from "react";
export default function Home() {
  useEffect(() => {
    Aos.init();
  }, []);

  const [isOpenBook, setIsOpenBook] = useState<boolean>(true);

  const openBook = () => {
    setIsOpenBook(true);
  };

  const { show, open, onClose } = useModal();
  return (
    <Layout>
      {isOpenBook ? (
        <div className="content tw-p-2 tw-w-full sm:tw-w-4/5 sm:tw-mx-auto md:tw-mx-auto md:tw-p-4  md:tw-w-3/5 ">
          <h3 className="tw-text-xl tw-mb-4">Thumnail</h3>
          <div className="tw-flex tw-flex-1 tw-flex-col tw-gap-4 sm:tw-flex-col md:tw-flex-row ">
            <div className="tw-flex-1 tw-flex tw-justify-center">
              <div className="tw-w-96 tw-h-96 tw-border tw-border-slate-300"></div>
            </div>
            <form className="tw-space-y-4 tw-flex-1">
              <Input id="name" label="Album name" type="text" />
              <DatePicker label="Time" />
              <Textarea id="description" label="Album name" />
              <div className="tw-flex tw-justify-end">
                <Button
                  type="submit"
                  text="Save"
                  theme="primary"
                  onClick={openBook}
                />
              </div>
            </form>
          </div>
        </div>
      ) : (
        <div
          className="tw-mx-auto tw-mt-40 tw-block tw-text-center tw-text-lg tw-text-slate-600"
          data-aos="zoom-in"
        >
          <div className="tw-mb-4">Create the first memory or album here</div>
          <Button
            text="Create"
            type="button"
            theme="primary"
            onClick={openBook}
          ></Button>
        </div>
      )}
    </Layout>
  );
}
