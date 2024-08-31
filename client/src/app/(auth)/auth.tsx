type AuthLayoutProps = {
  children: React.ReactNode;
};
export default function AuthLayout({ children }: AuthLayoutProps) {
  const styles = {
    backgroundWrapper: {
      backgroundImage: "linear-gradient(#F8E49B, #949E57);",
    },
  };

  return (
    <div
      className="tw-h-screen tw-w-full tw-bg-zinc-100"
      style={styles.backgroundWrapper}
    >
      <div className="tw-absolute tw-left-1/2 tw-top-1/2 -tw-translate-x-1/2 -tw-translate-y-1/2 tw-flex tw-items-center">
        {children}
      </div>
    </div>
  );
}
