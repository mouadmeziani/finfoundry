import type { Metadata } from "next";
import { Provider } from "@/components/ui/provider";

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
      <body>
        <Provider>{children}</Provider>
      </body>
    </html>
  );
}
