import { Transaction } from "@/types/transaction";
import TransactionCard from "./TransactionCard";

type TransactionListProps = {
  transactions: Transaction[];
};

export default function TransactionList({
  transactions,
}: TransactionListProps) {
  if (!transactions || transactions.length === 0) {
    return <p>No transactions available.</p>;
  }
  return (
    <section>
      {transactions.map((tx) => (
        <TransactionCard key={tx.id} transaction={tx} />
      ))}
    </section>
  );
}
