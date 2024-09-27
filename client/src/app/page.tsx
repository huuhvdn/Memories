"use client";
import { Button, Layout } from "@/components";
import Aos from "aos";
import "aos/dist/aos.css";
import { useEffect } from "react";
export default function Home() {
  useEffect(() => {
    Aos.init();
  }, []);
  return (
    <Layout>
      <div
        className="tw-mx-auto tw-mt-40 tw-block tw-text-center tw-text-lg tw-text-slate-600"
        data-aos="zoom-in"
      >
        <div className="tw-mb-4">Create the first memory or album here</div>
        <Button text="Create" type="button" theme="primary"></Button>
      </div>
    </Layout>
  );
}
