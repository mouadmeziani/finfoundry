import type { Metadata } from "next";

export const metadata = {
  title: "FinFoundry",
  description: "Your personal finance manager",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
