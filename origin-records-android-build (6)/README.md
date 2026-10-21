# Origin Records

A multi-company bookkeeping app for small businesses — invoices, revenue, expenses, banking, payroll, inventory, fixed assets, budgets, and financial reports, built on a real double-entry ledger under the hood. It runs as a native Android app (via Capacitor) and works fully offline.

## What it does

- **Dashboard** — a premium, banking-style home screen: a full-width hero with your net cash surplus (with a hide-amounts eye toggle), expected inflow from unpaid invoices, and one-tap buttons to add revenue, an expense or an invoice; below it, shortcuts, this month's figures, company profit, progress bars for gross margin and budget used, recent activity, and trend charts.
- **Invoices** — bill customers, record partial or full payments, track status (Sent / Partial / Overdue / Paid). Revenue is only recognised when a payment is recorded, not when an invoice is issued.
- **Revenue** — direct income entries (cash sales, other income) alongside invoice payments. Every entry carries its own cost of production, so gross margin is tracked at the transaction level.
- **Expenses** — categorised spending with VAT, paid/unpaid status, a vendor, and an attached receipt photo.
- **Contacts** — customers and vendors, with running balances (what a customer owes you, what you owe a vendor).
- **Budgets** — a monthly budget per expense category, tracked against actual spend.
- **Banking** — multiple bank accounts with a book-vs-statement balance reconciliation.
- **Inventory** — stock items with in/out movements and average-cost valuation.
- **Payroll** — employees, pay runs with PAYE and pension deductions, and payslips.
- **Assets** — fixed assets with straight-line depreciation, and a funding source (paid from a bank account, bought on credit, or contributed by the owner as capital) that posts correctly to the ledger either way.
- **Accounting** — the chart of accounts, a full general ledger, a trial balance, and manual journal entries, all generated automatically from everything above.
- **Reports** — income statement, statement of financial position, cash flow statement, financial ratios, VAT summary, and receivables ageing, for any period (a month, a quarter, a year, a custom range, or all time).
- **Company** — company profile, logo, currency, VAT rate, and the company-profit rate used on the dashboard.
- **Getting started** — a short refresher on core bookkeeping ideas, reachable any time from the sidebar/drawer menu (it only shows automatically before a company has been created).

Everything above a company's raw entries — the ledger, trial balance, income statement, balance sheet, and cash flow statement — is derived from one underlying double-entry bookkeeping engine, so the books always balance.

## Reports: PDF and CSV

Every report can be exported two ways, both shareable straight from the app with no extra software needed to view them:
- **PDF** — a full report (income statement, balance sheet, cash flow, ratios, and every revenue/expense line) plus a "Supporting Documents" section with every receipt or proof-of-payment image attached to an entry in that period.
- **CSV** — the same full detail, for spreadsheets.

Invoices and payslips can also be downloaded individually as PDFs.

## Editing attached images

Any receipt, proof-of-payment, or company logo can be rotated and cropped — either right after picking the file, or later by opening the existing attachment and tapping Edit.

## Works fully offline

The app needs no internet connection for anything: the icon set, the Montserrat font, and the PDF-generation library are all bundled inside the app itself rather than loaded from the internet, and all company data is stored on the device. (An optional cloud-sync path exists only when the app is run inside Claude's own environment — it is never used in the installed Android app.)

## Multi-company and theming

Switch between any number of companies from the top bar. Each company keeps its own entries, bank accounts, employees, and settings. Light and dark themes are both supported, with a toggle in the top bar.

## Project structure

```
www/index.html              the entire app: markup, styles, and logic in one file
capacitor.config.json       app id, name, splash screen settings
package.json                Capacitor dependencies
android-icons-res/          generated app icon (all densities) and splash screen images
android-src/MainActivity.java   locks text scaling so the layout stays consistent on any phone's font-size setting
android-src/debug.keystore  a fixed signing key, so every build can be installed as an update over the last
.github/workflows/build-apk.yml   builds the Android APK on GitHub's servers
```

## Building the APK

1. Create a new empty GitHub repository and upload everything in this folder (keep the `.github` folder — on some file managers you'll need to turn on "show hidden files" to see it, or upload from a computer).
2. Open the repo's **Actions** tab. The "Build APK" workflow runs automatically on every push to `main` (or click **Run workflow** to trigger it manually).
3. When it finishes (around 5 minutes), open the run, scroll to **Artifacts**, and download **origin-records-apk**. Unzip it to get `app-debug.apk`.
4. Copy the APK to your phone, open it, and allow "Install unknown apps" if asked. Later rebuilds will install cleanly as an update over the previous one, without needing to uninstall first.

To make changes, edit `www/index.html` and push — everything rebuilds from that one file (plus the icon/keystore files, which only need to change if you want a different icon or a different signing key).

## Recent updates

- Full visual redesign of the dashboard, inspired by modern banking apps: a gradient hero card with the net cash surplus and quick-action buttons, a Shortcuts row, redesigned month tiles, profit/budget progress bars, and a cleaner recent-activity list.
- Quick add moved into the dashboard hero, and its sheet was redesigned so all four options (Revenue, Expense, Invoice, Asset) share one consistent design.
- The top bar now shows only the company logo and name plus the theme switch.
- New floating navigation: a burgundy pill with a white focus pill that shows the icon and label of the current section, and a separate round More button for the full menu.
- Icon boxes and the welcome screen were restyled (the white edge accent was removed there), with a matching gradient welcome hero.
- Chart colours brightened in dark mode so revenue bars are readable.

- Converted the Reports, Invoice, and Payslip "Print" buttons into real PDF downloads (native print wasn't reliable inside the packaged app).
- Reports PDF now carries full line-by-line detail and attached receipt/proof images, not just a summary.
- Added image editing (crop and rotate) for every uploaded image, both at upload time and afterward.
- Rebuilt the mobile navigation as a 5-item bottom bar plus a full slide-out menu, replacing the old cramped icon row.
- Redesigned the dashboard's top figures around one featured number ("Net cash surplus") with two supporting figures beneath, instead of three stacked blocks.
- Fixed two accounting issues: fixed-asset purchases now post correctly to cash or payables instead of always crediting owner's capital, and the Reports page's asset-based ratios now use the same total-assets figure as the actual balance sheet.
- Made the whole app work fully offline: the icon set, font, and PDF library are now bundled in the app instead of loaded from the internet.
- Fixed the app being signed with a different key on every build, which was forcing an uninstall before every update.
- Locked the app's text size so it looks the same on every phone, regardless of the phone's own font-size setting.
- New app icon and a splash screen on launch.
