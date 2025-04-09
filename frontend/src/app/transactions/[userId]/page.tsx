import UserTransactionsClient from "./UserTransactionsClient";

export default async function UserTransactionsPage({
  params,
}: {
  params: { userId: string };
}) {
  const { userId } = await params;

  return (
    <main>
      <UserTransactionsClient userId={userId} />
    </main>
  );
}
