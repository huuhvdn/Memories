"use client";
import Grid from "@mui/material/Grid2";
import "aos/dist/aos.css";

interface MainLayoutProps {
  title: string;
  children: React.ReactNode;
}
const MainLayout: React.FC<MainLayoutProps> = ({
  title = "Our Memories App",
  children,
}) => {
  return (
    <>
      <div className="tw-w-full tw-h-screen">
        <div className="tw-h-14 tw-shadow-md tw-w-full ">s</div>
        <div className="tw-flex-1 tw-relative ">
          <Grid container size={12}>
            <Grid size={2}></Grid>
            <Grid size={8}>{children}</Grid>
            <Grid size={2}></Grid>
          </Grid>
        </div>
      </div>
    </>
  );
};

export default MainLayout;
