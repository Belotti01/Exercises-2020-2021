using System;
using System.Drawing;
using System.Windows.Forms;

namespace Bookmarks {
    
    public partial class BookmarkSetup : Form {
        private readonly BookmarkData ogBookmark;

        public BookmarkSetup() {
            InitializeComponent();
            ctrlBookmark.ToggleEditableMode(true);

            btnSave.MouseClick += SaveNew;
        }
        
        public BookmarkSetup(BookmarkData bookmark) {
            InitializeComponent();
            ogBookmark = bookmark;
            lblUrl.Text = bookmark.Url;
            ctrlBookmark.Data = bookmark;
            ctrlBookmark.LoadData();
            ctrlBookmark.ToggleEditableMode(true);

            btnSave.MouseClick += SaveEdits;
        }

        private void SaveNew(object sender, MouseEventArgs e) {
            if(!CanSave())
                return;

            var data = new BookmarkData() {
                Name = ctrlBookmark.lblName.Text,
                Description = ctrlBookmark.txtDescription.Text,
                Url = lblUrl.Text
            };
            data.AsControl = new Components.Bookmark(data);
            if(((MainForm)Owner).TryAdd(data.AsControl)) {
                Close();
            }else {
                MessageBox.Show("A bookmark with that Name or Url already exists.", "Warning", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void SaveEdits(object sender, MouseEventArgs e) {
            if(!CanSave())
                return;

            if(ctrlBookmark.lblName.Text == ogBookmark.Name
            && ctrlBookmark.txtDescription.Text == ogBookmark.Description
            && lblUrl.Text == ogBookmark.Url)
                Close();

            DialogResult confirmation = MessageBox.Show("Are you sure you want to overwrite changes?", "Confirm", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if(confirmation == DialogResult.Yes) {
                (Owner as MainForm).Remove(ogBookmark.AsControl);
                SaveNew(sender, e);
                //If form is not closed at this point, the control could not be added
                //Add back the removed bookmark
                (Owner as MainForm).TryAdd(ogBookmark.AsControl);
            }
        }

        private void Cancel(object sender, MouseEventArgs e)
            => Close();

        private bool CanSave() {
            bool isValid = true;
            if(!lblUrl.Text.IsValidLabel() || !lblUrl.Text.Contains('.')) {
                lblUrl.BackColor = Color.LightCoral;
                lblUrl.TextChanged += ResetBackColor;
                isValid = false;
            }
            if(!ctrlBookmark.txtDescription.Text.IsValidLabel()) {
                ctrlBookmark.txtDescription.BackColor = Color.LightCoral;
                ctrlBookmark.txtDescription.TextChanged += ResetBackColor;
                isValid = false;
            }
            return isValid;
        }

        private void ResetBackColor(object sender, EventArgs e) {
            if(sender is Control label) {
                label.BackColor = Color.FromArgb(44, 47, 51);
                label.TextChanged -= ResetBackColor;
            }
        }
    }
}
