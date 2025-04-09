"use client";
import { useEffect, useState } from "react";
import { Transaction } from "@/types/transaction";
import TransactionList from "@/components/TransactionList";

type Props = {
  userId: string;
};

export default function UserTransactionsClient({ userId }: Props) {
  const [transactions, setTransactions] = useState<Transaction[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchTransactions = async () => {
      try {
        setLoading(true);
        const res = await fetch(
          `http://localhost:8080/api/transactions/user/${userId}`
        );
        if (!res.ok) {
          throw new Error("Failed to fetch transactions");
        }
        const data = await res.json();
        setTransactions(data);
      } catch (err: any) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchTransactions();
  }, [userId]);

  if (loading) return <div>Loading transactions...</div>;
  if (error) return <div>{error}</div>;

  return <TransactionList transactions={transactions} />;
}
