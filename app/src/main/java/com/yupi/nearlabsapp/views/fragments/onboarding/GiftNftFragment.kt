package com.yupi.nearlabsapp.views.fragments.onboarding

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yupi.nearlabsapp.R
import com.yupi.nearlabsapp.base.BaseActivity
import com.yupi.nearlabsapp.base.OnBoardingBaseFragment
import com.yupi.nearlabsapp.databinding.FragmentGiftNftBinding
import com.yupi.nearlabsapp.extensions.initials
import com.yupi.nearlabsapp.models.Contact
import com.yupi.nearlabsapp.viewmodels.OnBoardingViewModel
import com.yupi.nearlabsapp.views.activities.MainActivity
import com.yupi.nearlabsapp.views.adapters.GenericAdapter
import kotlinx.android.synthetic.main.contact_cell.view.*

class GiftNftFragment : OnBoardingBaseFragment<FragmentGiftNftBinding, OnBoardingViewModel>() {

    private lateinit var adapter: GenericAdapter<Contact>

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGiftNftBinding
        get() = FragmentGiftNftBinding::inflate

    override fun inflated() {

        viewModel.contactsData.observe(viewLifecycleOwner, Observer {
            if (it == null)
                return@Observer

            if (!this::adapter.isInitialized)
                initAdapter(it)
            else adapter.setDataSource(it)
        })

        binding?.sendGiftBtn?.setOnClickListener {
            if (isAdded)
                (requireActivity() as BaseActivity<*, *>)
                    .startClearActivity(MainActivity::class.java)
        }
    }

    private fun initAdapter(contacts: Array<Contact>) {
        adapter = object : GenericAdapter<Contact>(contacts) {
            override fun bind(holder: GenericHolder, item: Contact) {
                if (item.contactName != null)
                    holder.itemView.username.text = item.contactName
                if (item.contactId != null)
                    holder.itemView.userId.text = item.contactId

                if (item.contactAvatar == null && item.contactName != null)
                    holder.itemView.initials.initials(item.contactName)
            }

            override fun getItemViewType(position: Int): Int {
                return R.layout.contact_cell
            }
        }
        binding?.contactsList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.contactsList?.setHasFixedSize(true)
        binding?.contactsList?.adapter = adapter

    }

    override val viewModel: OnBoardingViewModel
            by activityViewModels()
}